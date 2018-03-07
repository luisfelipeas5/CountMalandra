package br.com.madeinweb.labs.countmalandra.di

import br.com.madeinweb.labs.countmalandra.helpers.api.ApiContractHelper
import br.com.madeinweb.labs.countmalandra.total.TotalContract
import br.com.madeinweb.labs.countmalandra.total.TotalDataManager
import dagger.Module
import dagger.Provides

@Module
class DataManagerModule {

    @Provides
    fun provideTotalDataManager(apiContractHelper: ApiContractHelper): TotalContract.DataManager {
        return TotalDataManager(apiContractHelper)
    }

}