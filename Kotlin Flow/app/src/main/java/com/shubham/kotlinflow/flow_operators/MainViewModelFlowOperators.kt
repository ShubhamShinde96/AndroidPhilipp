package com.shubham.kotlinflow.flow_operators

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModelFlowOperators : ViewModel() {

    // 2

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


    init {
        terminalFlowOperators()
//        collectFlow()
    }


    private fun collectFlow() {

        /*countdownFlow.onEach {
            print(it)  // can do it like that as a shorter way
        }.launchIn(viewModelScope)*/

        viewModelScope.launch {
            countdownFlow
                .filter { time ->   // So this is filer operator, just like we use it on array in kotlin
                    time % 2 == 0  // need to satisfy the condition and return the filtered values, otherwise err
                }                   // here we are getting even values

                .map { time ->
                    time * time  // here we can manipulate the actual flow value(which is time here)
                }                   // here we're getting multiplied values

                .onEach { time ->
                    println(time)                    // By using this we can do something with it.
                }
                .collect { time ->

                    println("The current time is $time") // see the logs, not UI, as we're only applied this filter here in this collect block, not in the MainActivity
                }
        }

    }

    private fun terminalFlowOperators() {

        viewModelScope.launch {
//            val count = countdownFlow.filter { time -> // commented for .reduce { }
            val reducedResult = countdownFlow.filter { time ->
                time % 2 == 0
            }
//                .count {   // So instead of collect here we're finishing off with terminal operator of Flow
//                it % 2 == 0      // count { } will count the values that match a specific condition
//                // so here what we're saying is if the emission is an even number then count it
//                // and we're storing the count { } returned value in "count" var
//            }  // we don't need to perform any prior operation like "filter { }" to perform count { }
                /*. reduce { accumulator, value ->
                    Log.d("REDUCE_LOG", "accumulator: $accumulator, value: $value") // check logs to understand reduce { }
                    accumulator + value
                }*/
                .fold(100) { accumulator, value ->
                    Log.d(
                        "FOLD_LOG",
                        "accumulator: $accumulator, value: $value"
                    ) // check logs to understand fold { }
                    accumulator + value
                }

//            Log.d("REDUCE_LOG", "The count is $reducedResult")
            Log.d("FOLD_LOG", "The count is $reducedResult")
            println("The count is $reducedResult")
        }

    }


}



























