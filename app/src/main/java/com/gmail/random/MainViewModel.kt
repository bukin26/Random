package com.gmail.random

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

private const val START_DELAY = 0L
private const val REGULAR_DELAY = 3L

class MainViewModel : ViewModel() {

    private val backgroundExecutor: ScheduledExecutorService =
        Executors.newSingleThreadScheduledExecutor()
    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number

    init {
        start()
    }

    private fun start() {
        backgroundExecutor.scheduleAtFixedRate({
            _number.postValue((0..10).random())
        }, START_DELAY, REGULAR_DELAY, TimeUnit.SECONDS)
    }

    override fun onCleared() {
        super.onCleared()
        backgroundExecutor.shutdown()
    }
}