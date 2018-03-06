package br.com.madeinweb.labs.countmalandra.total

import io.reactivex.Single

class TotalDataManager: TotalContract.DataManager {
    override fun getCount(): Single<Int> {
        return Single.just(3)
    }
}