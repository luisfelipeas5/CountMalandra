package br.com.madeinweb.labs.countmalandra.di

import br.com.madeinweb.labs.countmalandra.total.TotalContract
import br.com.madeinweb.labs.countmalandra.total.TotalDataManager
import dagger.Module
import dagger.Provides

@Module
class DataManagerModule {

    @Provides
    fun provideTotalDataManager(): TotalContract.DataManager {
        return TotalDataManager()
    }

}