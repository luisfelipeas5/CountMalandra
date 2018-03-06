package br.com.madeinweb.labs.countmalandra.basearchitecture

import io.reactivex.disposables.Disposable

open class BasePresenter<V: BaseContract.View>: BaseContract.Presenter<V> {

    protected var mView: V? = null
    protected var mDisposables: MutableList<Disposable> = mutableListOf()

    override fun attach(view: V) {
        mView = view
        mView!!.getLifecycle().addObserver(this)
    }

    override fun detach() {
        for (disposable: Disposable in mDisposables) {
            disposable.dispose()
        }
        mView = null
    }

}