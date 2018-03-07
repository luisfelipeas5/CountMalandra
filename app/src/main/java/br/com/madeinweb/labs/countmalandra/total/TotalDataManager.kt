package br.com.madeinweb.labs.countmalandra.total

import br.com.madeinweb.labs.countmalandra.helpers.api.ApiContractHelper
import io.reactivex.Observable

class TotalDataManager(private val mApiContractHelper: ApiContractHelper): TotalContract.DataManager {

    override fun getTotal(): Observable<Int> {
        return mApiContractHelper.getTotal()
    }
}