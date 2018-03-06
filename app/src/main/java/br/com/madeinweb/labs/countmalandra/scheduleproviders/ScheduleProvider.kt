package br.com.madeinweb.labs.countmalandra.scheduleproviders

import io.reactivex.Scheduler

interface ScheduleProvider {
    fun io(): Scheduler
    fun ui(): Scheduler
}