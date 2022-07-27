package com.shubham.kotlinflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    // 1

    val countdownFlow = flow<Int> {


        // we can execute suspend function here inside this block
        val startingValue = 10
        var currentValue = startingValue

        emit(startingValue) // emitting starting value

        while (currentValue > 0) {

            delay(1000L)
            currentValue--

            // now we want notify our UI about change in "currentValue"
            emit(currentValue)
        }
    }  // So this is normal flow also referred as "cold flow", cause it doesn't do anything unless there are subscribers(collect the data)
    // means this code will only get executed after we call "collect" function on it.

    // on the other side, a "Hard Flow" is always emitting values even if there are no collectors.

    init {
        collectFlow()
    }

    //  we can write a function to collect that flow
    private fun collectFlow() {

        viewModelScope.launch {
            countdownFlow.collect { time ->
                delay(1500L)
                println("The current time is $time")  // Will print all the emitted values with 1.5 sec delay
            }

            /*countdownFlow.collectLatest { time ->
                delay(1500L)
                println("The current time is $time")  // Will directly print 0 as there was delay, so it will only collect the latest value.
            }*/


        }
    }

}