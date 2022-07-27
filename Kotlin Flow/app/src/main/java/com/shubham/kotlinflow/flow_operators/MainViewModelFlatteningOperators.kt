package com.shubham.kotlinflow.flow_operators

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModelFlatteningOperators: ViewModel() {

    // 3

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

    //  if we have list of lists like this
    //  [[1, 2], [1,2,3]]

    //  now if we flatten this list of list then it would look like this
    //  [1, 2, 1, 2, 3]

    // and with flow we have something similar, the difference is here we don't flatten list instead here we
    // flatten "flows"
    // So if we have 2 flows then we can combine the results coming in a single flow

    private fun collectFlow() {

        val flow1 = flow {
            emit(1)
            delay(500L)
            emit(2)
        }



        viewModelScope.launch {

            flow1.flatMapConcat { value -> // so in here it is a trigger for every single emmition just like collect
                // but hee this function needs to return a flow

                flow {
                    emit(value + 1)
                    delay(500L)
                    emit(value + 2)
                }
            }.collect { value ->
                 Log.d("FLAT_MAP", "The value is $value")
            }

            // so output is:
//            The value is 2     so here 1 will come inside "flatMapConcat" and it will emit 2 values from it
//            The value is 3
//            The value is 3     then 2 will come inside "flatMapConcat" and it will emit 2 values from it
//            The value is 4

        }


        // so basically if you have recipe app and you show user recipe list from local DB and then you make a
        // network call to get up-to-date recipe list & then you display that list again(reflect) to user.
        // So you'll get multiple recipes and there might be some scenarios like this that will require to combine
        // such list in some way then you can use this

        // so we'll mimic the recipe scenario

        val recipeFlow = (1..5).asFlow()

        /*flow1.flatMapConcat { id ->

            getRecipeById(id) // so that would be a function that access your cache and returns a flow
            // and you take all the emmitions that comes from this function

        }.collect { value ->
            Log.d("FLAT_MAP", "The value is $value") // and collect them here in this single block.
        }*/
        // but you don't just do that for single recipe but instead you do that for 5 recipes



        // we also have
        /*flow1.flatMapMerge { id ->

            getRecipeById(id)

        }.collect { value ->
            Log.d("FLAT_MAP", "The value is $value")
        }*/

        // we also have
        /*flow1.flatMapLatest { id ->

            getRecipeById(id)

        }.collect { value ->
            Log.d("FLAT_MAP", "The value is $value")
        }*/
    }

}