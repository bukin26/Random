package com.gmail.random

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

private const val START_DELAY = 0L
private const val REGULAR_DELAY = 3L

class MainViewModel : ViewModel() {

    val numberSource: Observable<Int> =
        Observable.interval(START_DELAY, REGULAR_DELAY, TimeUnit.SECONDS)
            .flatMap {
                return@flatMap Observable.create<Int> {
                    it.onNext((0..100).random())
                }
            }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
}