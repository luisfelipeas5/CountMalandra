package br.com.madeinweb.labs.countmalandra.di

import br.com.madeinweb.labs.countmalandra.total.TotalContract
import br.com.madeinweb.labs.countmalandra.total.TotalPresenter
import br.com.madeinweb.labs.countmalandra.scheduleproviders.AppSchedulerProvider
import br.com.madeinweb.labs.countmalandra.scheduleproviders.ScheduleProvider
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideSchedulerProvider(): ScheduleProvider {
        return AppSchedulerProvider()
    }

    @Provides
    fun provideTotalPresenter(totalDataManager: TotalContract.DataManager, schedulerProvider: ScheduleProvider): TotalContract.Presenter {
        return TotalPresenter(totalDataManager, schedulerProvider)
    }

}