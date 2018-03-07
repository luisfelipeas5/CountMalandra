package br.com.madeinweb.labs.countmalandra.total

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import br.com.madeinweb.labs.countmalandra.R
import br.com.madeinweb.labs.countmalandra.basearchitecture.BasePresenter
import br.com.madeinweb.labs.countmalandra.scheduleproviders.ScheduleProvider
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class TotalPresenter(private var mDataManager: TotalContract.DataManager, private var mScheduleProvider: ScheduleProvider) : BasePresenter<TotalContract.View>(), TotalContract.Presenter {

    private var mLoading: Boolean = false
    private var mChangeTotalColorDisposable: Disposable? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun loadTotal() {
        mDataManager.getTotal()
                .subscribeOn(mScheduleProvider.io())
                .observeOn(mScheduleProvider.ui())
                .subscribe(object : Observer<Int> {
                    override fun onNext(total: Int) {
                        mView?.onCountReady(total)
                        if (mLoading) {
                            mLoading = false
                            mView?.onLoadingTotal(false)
                        }
                        changeTotalColor()
                    }

                    override fun onComplete() {
                    }

                    override fun onError(e: Throwable) {
                        mView?.onLoadCountFailed(e)
                        mView?.onLoadingTotal(false)
                    }

                    override fun onSubscribe(disposable: Disposable) {
                        mDisposables.add(disposable)
                        mLoading = true
                        mView?.onLoadingTotal(true)
                    }

                })
    }

    private fun changeTotalColor() {
        if (mChangeTotalColorDisposable != null) {
            mChangeTotalColorDisposable!!.dispose()
        }

        mView?.changeTotalColor(R.color.colorPrimary)
        Completable.timer(3, TimeUnit.SECONDS)
                .subscribe(object: CompletableObserver {
                    override fun onComplete() {
                        mView?.changeTotalColor(R.color.black)
                    }

                    override fun onSubscribe(disposable: Disposable) {
                        mDisposables.add(disposable)
                        mChangeTotalColorDisposable = disposable
                    }

                    override fun onError(e: Throwable) {
                    }

                })
    }

}