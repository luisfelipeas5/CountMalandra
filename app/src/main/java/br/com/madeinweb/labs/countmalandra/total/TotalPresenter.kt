package br.com.madeinweb.labs.countmalandra.total

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import br.com.madeinweb.labs.countmalandra.basearchitecture.BasePresenter
import br.com.madeinweb.labs.countmalandra.scheduleproviders.ScheduleProvider
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class TotalPresenter(private var mDataManager: TotalContract.DataManager, private var mScheduleProvider: ScheduleProvider) : BasePresenter<TotalContract.View>(), TotalContract.Presenter {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun loadCount() {
        mDataManager.getCount()
                .subscribeOn(mScheduleProvider.io())
                .observeOn(mScheduleProvider.ui())
                .subscribe(object : SingleObserver<Int>{
                    override fun onSuccess(count: Int) {
                        mView?.onCountReady(count)
                    }

                    override fun onError(e: Throwable) {
                        mView?.onLoadCountFailed(e)
                    }

                    override fun onSubscribe(disposable: Disposable) {
                        mDisposables.add(disposable)
                    }

                })
    }

}