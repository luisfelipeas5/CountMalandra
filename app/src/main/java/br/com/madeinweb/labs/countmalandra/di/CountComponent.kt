package br.com.madeinweb.labs.countmalandra.di

import br.com.madeinweb.labs.countmalandra.total.TotalActivity
import dagger.Component

@Component(modules = arrayOf(PresenterModule::class, DataManagerModule::class, HelperModule::class))
abstract class CountComponent {
    abstract fun inject(totalActivity: TotalActivity)
}