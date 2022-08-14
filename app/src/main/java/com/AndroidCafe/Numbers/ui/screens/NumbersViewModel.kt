package com.AndroidCafe.Numbers.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.properties.Delegates
import kotlin.math.round

class NumbersViewModel : ViewModel() {

    var currentTime by mutableStateOf(0f)
        private set

    private val _displayNumbers = mutableStateListOf<Number>()
    val displayNumbers:List<Number> = _displayNumbers

    private lateinit var randomNumbers:List<Int>
    private var lastIndex by Delegates.notNull<Int>()
    private var currentNumber by Delegates.notNull<Int>()
    private var timerJob: Job? = null

    init {
        reset()
    }

    fun onRestartClick() {
        reset()
    }

    fun onNumberClick(index: Int) {

        if(_displayNumbers[index].value != currentNumber) return

        if(currentNumber == 1) {
            startTimer()
        }

        ++lastIndex
        ++currentNumber

        val value = randomNumbers[lastIndex]
        val hidden = currentNumber < 25

        _displayNumbers[index] = Number(value = value, hidden)
    }

    private fun startTimer() {
        cancelTimer()
        timerJob = viewModelScope.launch {
            while(true) {
                delay(100)
                currentTime += 0.1f
            }
        }
    }

    private fun cancelTimer() {
        timerJob?.cancel()
        currentTime = 0f
    }

    private fun reset() {
        cancelTimer()
        generateRandomNumbers()
    }

    private fun generateRandomNumbers(){
        randomNumbers = Utils.genRandomNumbers()

        _displayNumbers.clear()
        //fromIndex and toIndex are exclusive
        val randomValues = randomNumbers.subList(fromIndex = 0, toIndex = 25)
        for(value in randomValues) {
            _displayNumbers.add(Number(value))
        }

        lastIndex = 24
        currentNumber = 1
    }
}