package br.com.madeinweb.labs.countmalandra.di

import br.com.madeinweb.labs.countmalandra.helpers.api.ApiContractHelper
import br.com.madeinweb.labs.countmalandra.helpers.api.FirebaseApiHelper
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides

@Module
class HelperModule {

    @Provides
    fun provideFirebaseDatabase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    @Provides
    fun provideApiContractHelper(firebaseDatabase: FirebaseDatabase): ApiContractHelper {
        return FirebaseApiHelper(firebaseDatabase)
    }

}