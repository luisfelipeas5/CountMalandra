package br.com.madeinweb.labs.countmalandra.basearchitecture

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver

class BaseContract {

    interface View {
        fun getLifecycle(): Lifecycle
    }

    interface Presenter<V: View>: LifecycleObserver {
        fun attach(view: V)
        fun detach()
    }

}