package com.AndroidCafe.Numbers.ui.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlin.properties.Delegates

class NumbersViewModel : ViewModel() {

    val displayNumbers = mutableStateListOf<Number>()

    private lateinit var randomNumbers:List<Int>
    private var lastIndex by Delegates.notNull<Int>()
    private var currentNumber by Delegates.notNull<Int>()

    init {
        reset()
    }

    fun onRestartClick() {
        reset()
    }


    fun onNumberClick(index: Int) {

        if(displayNumbers[index].value != currentNumber) return

        ++lastIndex
        ++currentNumber

        val value = randomNumbers[lastIndex]
        val hidden = currentNumber < 25

        displayNumbers[index] = Number(value = value, hidden)
    }

    private fun reset() {
        generateRandomNumbers()
        lastIndex = 24
        currentNumber = 1
    }


    private fun generateRandomNumbers(){
        randomNumbers = Utils.genRandomNumbers()

        displayNumbers.clear()
        //fromIndex and toIndex are exclusive
        val randomValues = randomNumbers.subList(fromIndex = 0, toIndex = 25)
        for(value in randomValues) {
            displayNumbers.add(Number(value))
        }
    }
}