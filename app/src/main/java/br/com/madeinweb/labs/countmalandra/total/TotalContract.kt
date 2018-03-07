package br.com.madeinweb.labs.countmalandra.total

import br.com.madeinweb.labs.countmalandra.basearchitecture.BaseContract
import io.reactivex.Observable

interface TotalContract {

    interface Presenter: BaseContract.Presenter<View>

    interface View: BaseContract.View {
        fun onCountReady(count: Int)
        fun onLoadCountFailed(throwable: Throwable)
        fun onLoadingTotal(loading: Boolean)
        fun changeTotalColor(colorResource: Int)
    }

    interface DataManager {
        fun getTotal(): Observable<Int>
    }

}