package com.shubham.kotlinflow.flow_operators

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModelOtherOperators: ViewModel() {

    // 4

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
        collectFlow()
    }


    private fun collectFlow() {

        val flow = flow {

            delay(250L)
            emit("Appetizer")
            delay(1000L)
            emit("Main Dish")
            delay(100L)
            emit("Ice Cream")
        }

        /*viewModelScope.launch {

            flow.onEach {

                println("FLOW: $it is delivered'")
            }
                .collect {
                    println("FLOW: now eating $it")
                    delay(1500L)
                    println("FLOW: finished eating $it")
                }*/

//            output is:
//            Appetizer is delivered'
//            now eating Appetizer
//            finished eating Appetizer
//            Main Dish is delivered'
//            now eating Main Dish
//            finished eating Main Dish
//            Ice Cream is delivered'
//            now eating Ice Cream
//            finished eating Ice Cream

            // Now here what happens is when onEach { } get executed then collect { } will get executed & for emitting
            // next value onEach { } has to wait until previous value get emitted by collect { }

            // Now there are some different strategies for this

            // 1] Buffer  2] Conflate


            // 1st Strategy: BUFFER

            /*viewModelScope.launch {

                flow.onEach {

                    println("FLOW: $it is delivered'")
                }
                    .buffer()
                    .collect {
                        println("FLOW: now eating $it")
                        delay(1500L)
                        println("FLOW: finished eating $it")
                    }*/
//                output is:
//                Appetizer is delivered'
//                now eating Appetizer
//                Main Dish is delivered'
//                Ice Cream is delivered'
//                finished eating Appetizer
//                now eating Main Dish
//                finished eating Main Dish
//                now eating Ice Cream
//                finished eating Ice Cream

                // Here what happening is everything is running in different coroutine asynchronous to each other


                // 2nd Strategy: CONFLATE
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

//        output is:
//        Appetizer is delivered'
//        now eating Appetizer
//        Main Dish is delivered'
//        Ice Cream is delivered'
//        finished eating Appetizer
//        now eating Ice Cream
//        finished eating Ice Cream

        // so here conflate() is skipping some operations after 3/4 first initial operations
    }

}