package com.shubham.kotlinflow.sharedflow_and_stateflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModelStateFlow: ViewModel() {

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
    } // this countdownFlow is a cold flow, that means it only emits where there are collectors(when we collect it)
    // otherwise it just won't get executed
    // unlike this countdownFlow emits multiple values over a period of time
    // the state flow only holds and emits a single value
    // and that behaviour makes it a so called hot flow
    // Hot flow: it will still do something even if there are no collectors (even if we don't collect it)
    // Typically we have all of our state flows in our viewModel & these just contain our UI state

    // and we declare these with immutable versions from outside viewModel(private) that is only this viewModel
    // can modify
    private val _stateFlow = MutableStateFlow(0)  //so _underscore version always means it's mutable
//    (0) is the starting value
            // then we'll have public immutable version that our UI actually can subscribe to and collect

    // Now we'll create an public immutable version that can't be changes but it can be collected by viewModel user
    val stateFlow = _stateFlow.asStateFlow() // asStateFlow() will return immutable version of that state flow
    // as the activity/fragment(UI) should not change the values of ViewModel directly
    // now we'll collect this stateFlow from our activity

//    As we know when we rotate our device the activity gets recreated and which means all the ui state is lost
//    and if we don't save the UI state in our ViewModel then it will be lost, so that's why we have these
//    stateFlows to store the UI state in it just like this counter here

    fun incrementCounter() {
//        _stateFlow.value = stateFlow.value + 1
        _stateFlow.value += 1

        // now what will happen is when our activity gets recreated on rotation our collectors of that stateFLow
        // will fire up again and notify our ui about that current value which could be one or two maybe..
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


















