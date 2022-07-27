 package com.shubham.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

 class AsyncAwaitActivity : AppCompatActivity() {

//        5

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_await)

        // if we have multiple suspend functions and we are calling them 1 after another in coroutine scope
        // they will execute sequentially, one after another
        // however if we want to execute them both at the same time asynchronously then we can use async and await.


        /*GlobalScope.launch(Dispatchers.IO) {

            // to see time difference, kotlin as very cool function with which we can easily measure the time
            // a piece of code needs for it's execution, it's used below

//            val time = measureTimeMillis {
//
//                val answer1 = networkCall1()
//                val answer2 = networkCall2()
//
//                Log.i(TAG, "Answer 1 is: $answer1")
//                Log.i(TAG, "Answer 2 is: $answer2")
//
//            }
//
//            Log.i(TAG, "Request took $time ms.")

            // so these 2 logs will get printed after 6 seconds, as we have delayed each dummy network call
            // function for 3 seconds & the execution of these log function will going to happen after both
            // function completes their execution(line by line).
            // you can see the logged time.
            // here now if you want to execute this functions asynchronously then what we could do is start a
            // new coroutine for calling each function, like below

            val time  = measureTimeMillis {
                var answer1: String? = null
                var answer2: String? = null

                val job1 = launch {
                    answer1 = networkCall1()
                }

                val job2 = launch {
                    answer2 = networkCall2()
                }

                job1.join()
                job2.join() // doing this because if we don't do this then the logs will get printed like
                // "Answer 1 is: null"
                // "Answer 2 is: null"

                // now that we have used join and launched both functions in separate coroutine it will take
                // 3 seconds for both functions to be executed, now the situation is much better.

                Log.i(TAG, "Answer 1 is: $answer1")
                Log.i(TAG, "Answer 2 is: $answer2")

            }

            Log.i(TAG, "Request took $time ms.")

            // now we have executed both functions asynchronously from each other but the approach we have
            // used is actually very terrible, it's a very bad practice.
            // Consider below global scope coroutine for proper way of implementing it.
        }*/


        GlobalScope.launch(Dispatchers.IO) {

            val time  = measureTimeMillis {

                // instead code practice in above GlobalScope, what we can do here is we can use async
                // it is very similar to launch, it will also start a new coroutine but it won't return a job
                // like the launch function, instead it will return differed, and this differed can be used to
                // get the result of the calculation/network call.

                val answer1 = async { networkCall1() }
                val answer2 = async { networkCall2() } // so this async is returning Differed<String>

                Log.i(TAG, "Answer 1 is: ${answer1.await()}") // so .await() will block the current
                // coroutine (which is our GlobalScope) until the answer1 is available

                Log.i(TAG, "Answer 2 is: $answer2") // the same for answer2

                // So now we are doing this in a much better way, so whenever
                // so you should always use async if you're using a coroutine that returns some kind of a result.
                // And btw you can also use async instead of launch{}
                // consider below ex:

//                GlobalScope.async(Dispatchers.IO) {  } // but for now this just doesn't make any sense

            }

            Log.i(TAG, "Request took $time ms.")
        }


    }

    suspend fun networkCall1(): String {

        delay(3000L)
        return "Answer 1"
    }

    suspend fun networkCall2(): String {

        delay(3000L)
        return "Answer 2"
    }


}





































