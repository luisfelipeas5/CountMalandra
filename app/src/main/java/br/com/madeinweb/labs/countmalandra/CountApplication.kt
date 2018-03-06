package br.com.madeinweb.labs.countmalandra

import android.app.Application
import br.com.madeinweb.labs.countmalandra.di.CountComponent
import br.com.madeinweb.labs.countmalandra.di.DaggerCountComponent

class CountApplication: Application() {
    var diComponent: CountComponent? = null

    override fun onCreate() {
        super.onCreate()
        diComponent = DaggerCountComponent.builder()
                .build()
    }
}