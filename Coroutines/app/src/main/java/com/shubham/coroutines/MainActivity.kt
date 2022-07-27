package com.shubham.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // 1

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This is very simplest way to launch a coroutine, not really the best way.
        GlobalScope.launch {
            // GlobalScope means that this coroutine will live as long as our application does
            // If our application dies in the middle of execution inside GlobalScope then code will stop executing
            // in the middle cause GlobalScope is bound to execute until our application is alive, once it gets
            // destroyed our GlobalScope will also gets destroyed.

            // just like we have sleep() function for threads, here we have delay() function in coroutines.
            delay(3000L)

            Log.i(TAG, "Coroutine says hello from thread ${Thread.currentThread().name}")

            val networkCallResponse = doNetworkCall()
            val networkCallResponse2 = doNetworkCall2()

            Log.i(TAG, "networkCallResponse1 $networkCallResponse")
            Log.i(TAG, "networkCallResponse2 $networkCallResponse2")

            // You'll notice here that these 2 network call are not running in the different threads, these are running in same thread inside this coroutine
            // so second function needs to wait until 1st function gets executed.
        }

        Log.i(TAG, "hello from thread ${Thread.currentThread().name}")


    }


    suspend fun doNetworkCall(): String {

        // suspend functions can only be called from another suspend functions or from coroutines.

        delay(3000)

        return "This is the answer"
    }

    suspend fun doNetworkCall2(): String {

        delay(3000)

        return "This is the answer"
    }



}





































