package com.AndroidCafe.Numbers.ui.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class NumbersViewModel : ViewModel() {

    val displayNumbers = mutableStateListOf<Number>()

    private lateinit var randomNumbers:List<Int>
    private var currentIndex = 0

    init {
        generateRandomNumbers()
    }

    fun generateRandomNumbers(){
        randomNumbers = Utils.genRandomNumbers()

        displayNumbers.clear()
        //fromIndex and toIndex are exclusive
        val randomValues = randomNumbers.subList(fromIndex = 0, toIndex = 25)
        for(value in randomValues) {
            displayNumbers.add(Number(value))
        }

        currentIndex = 24
    }

    fun onNumberClick(index: Int) {

    }

}