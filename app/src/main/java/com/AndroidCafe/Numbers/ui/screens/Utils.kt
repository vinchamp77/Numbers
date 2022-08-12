package com.AndroidCafe.Numbers.ui.screens

object Utils {
    fun genRandomNumbers(start: Int, end: Int) : List<Int> {
        val list = mutableListOf<Int>()
        for(value in start..end){
            list.add(value)
        }
        list.shuffle()
        return list
    }

    fun genRandomNumbers(): List<Int> {
        val list1 = genRandomNumbers(start=1, end=25)
        val list2 = genRandomNumbers(start=26, end=50)
        return list1 + list2
    }
}