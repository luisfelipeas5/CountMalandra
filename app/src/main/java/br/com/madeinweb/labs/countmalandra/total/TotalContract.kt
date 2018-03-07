package br.com.madeinweb.labs.countmalandra.total

import br.com.madeinweb.labs.countmalandra.basearchitecture.BaseContract
import io.reactivex.Observable
import io.reactivex.Single

interface TotalContract {

    interface Presenter: BaseContract.Presenter<View> {

    }

    interface View: BaseContract.View {
        fun onCountReady(count: Int)
        fun onLoadCountFailed(throwable: Throwable)
    }

    interface DataManager {
        fun getTotal(): Observable<Int>
    }

}