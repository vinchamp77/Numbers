package com.AndroidCafe.Numbers.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

private object PreferencesKeys {
    val BEST_TIME = floatPreferencesKey("best_time")
}

class MainViewModel(private val dataStore: DataStore<Preferences>) : ViewModel() {

    private val bestTimeFlow: Flow<Float> = dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.BEST_TIME] ?: 0f
        }

    var bestTime by mutableStateOf(0f)
        private set

    var currentTime by mutableStateOf(0f)
        private set

    private val _displayNumbers = mutableStateListOf<Number>()
    val displayNumbers:List<Number> = _displayNumbers

    var showResult by mutableStateOf(false)
        private set

    private lateinit var randomNumbers:List<Int>
    private var lastIndex by Delegates.notNull<Int>()
    private var currentNumber by Delegates.notNull<Int>()
    private var timerJob: Job? = null

    init {
        reset()

        viewModelScope.launch {
            bestTimeFlow.collect { value ->
                bestTime = value
            }
        }
    }

    fun onRestartClick() {
        reset()
    }

    fun onNumberClick(index: Int) {

        if(_displayNumbers[index].value != currentNumber) return

        if(currentNumber == 1) {
            startTimer()
        }

        if(currentNumber <= 25) {
            val newValue = randomNumbers[++lastIndex]
            _displayNumbers[index] = Number(value = newValue, hidden = false)
        } else {
            _displayNumbers[index] = Number(value = currentNumber, hidden = true)
        }

        if(currentNumber == 50) {
            if(bestTime == 0f || currentTime < bestTime) {
                updateBestTimePref(currentTime)
            }
        } else {
            ++currentNumber
        }
    }

    private fun updateBestTimePref(bestTime: Float) {
        viewModelScope.launch {
            dataStore.edit { preferences ->
                preferences[PreferencesKeys.BEST_TIME] = bestTime
            }
        }
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
        //toIndex are exclusive
        val randomValues = randomNumbers.subList(fromIndex = 0, toIndex = 25)
        for(value in randomValues) {
            _displayNumbers.add(Number(value))
        }

        lastIndex = 24
        currentNumber = 1
    }
}