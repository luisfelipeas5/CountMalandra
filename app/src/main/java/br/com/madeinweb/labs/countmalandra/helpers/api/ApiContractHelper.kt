package br.com.madeinweb.labs.countmalandra.helpers.api

import io.reactivex.Observable

interface ApiContractHelper {
    fun getTotal(): Observable<Int>
}