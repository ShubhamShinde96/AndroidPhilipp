package com.shubham.kotlinflow.sharedflow_and_stateflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModelSharedFlow: ViewModel() {

    // 5

    // As the name says, state flow is used to keep the state
    // it's like liveData without lifecycle awareness
    // if there is new change then it will notify its collectors(observers) but it is not aware of activity or fragment lifecycle.

    val countdownFlow = flow<Int> {

        val startingValue = 10
        var currentValue = startingValue

        emit(startingValue)

        while (currentValue > 0) {

            delay(1000L)
            currentValue--

            emit(currentValue)
        }
    }


    private val _sharedFlow = MutableSharedFlow<Int>()// this doesn't need a initial value unlike state flow
    val shared = _sharedFlow.asSharedFlow()

    fun incrementCounter() {
//        _stateFlow.value = stateFlow.value + 1
        _stateFlow.value += 1

    }

    /*init {
        collectFlow()
    }*/


    private fun collectFlow() {

        val flow = flow {

            delay(250L)
            emit("Appetizer")
            delay(1000L)
            emit("Main Dish")
            delay(100L)
            emit("Ice Cream")
        }


        viewModelScope.launch {

            flow.onEach {

                println("FLOW: $it is delivered'")
            }
                .conflate()
                .collect {
                    println("FLOW: now eating $it")
                    delay(1500L)
                    println("FLOW: finished eating $it")
                }
        }
    }



}


















