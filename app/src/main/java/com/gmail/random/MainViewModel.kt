package com.gmail.random

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

private const val REGULAR_DELAY = 3000L

class MainViewModel : ViewModel() {

    private val _numberFlow = MutableStateFlow(getRandomNumber())
    val numberFlow: StateFlow<Int>
        get() = _numberFlow

    init {
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                delay(REGULAR_DELAY)
                _numberFlow.emit(getRandomNumber())
            }
        }
    }

    private fun getRandomNumber(): Int {
        return (0..100).random()
    }
}