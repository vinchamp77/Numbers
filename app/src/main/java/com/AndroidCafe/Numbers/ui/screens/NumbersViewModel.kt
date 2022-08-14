package com.AndroidCafe.Numbers.ui.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class NumbersViewModel : ViewModel() {

    private lateinit var randomNumbers:List<Int>

    val displayNumbers = mutableStateListOf<Int>()

    private var currentIndex = 0

    init {
        generateRandomNumbers()
    }

    fun generateRandomNumbers(){
        randomNumbers = Utils.genRandomNumbers()

        displayNumbers.clear()
        //fromIndex and toIndex are exclusive
        displayNumbers.addAll(randomNumbers.subList(fromIndex = 0, toIndex = 25))
        currentIndex = 24
    }

    fun onNumberClick(index: Int) {

    }

}