package com.shubham.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class RunBlockingActivity : AppCompatActivity() {

//    3

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_run_blocking)

        // there is a function that will start a coroutine in the Main thread and also block it which is called
        // runBocking

        // note: runBlocking starts on thread on which you've started it, it does not always start on main thread.

        runBlocking {

        }

        GlobalScope.launch(Dispatchers.Main) { }

        // so the difference between this runBlocking and GlobalScope.launch(Dispatchers.Main) {  } is that
        // the runBlocking will actually block the main thread and GlobalScope.launch(Dispatchers.Main) {  } will
        // not block the main thread
        // I mean if you run delay(1000L) in that GlobalScope Main thread then we can still use the UI while we're
        // delaying that but if you do delay(1000L) in runBlocking then it will block our UI updates while we're delaying it

        // so the question is why will i want to block my main thread using runBlocking ?
        // so this can be useful when you don't necessarily need that coroutine behaviour but still want to call
        // suspend functions in your main thread
        // so basically you cannot call delay(1000L) inside onCreate() directly so basically if you call delay
        // inside runBlocking then it's same as calling that delay() inside onCreate() or on the UI thread.

        Log.i(TAG, "Before runBlocking")

        runBlocking {

            Log.i(TAG, "Start of runBlocking")
            delay(5000L)
            Log.i(TAG, "End of runBlocking")
        }

        Log.i(TAG, "After runBlocking")

//        so above code is equivalent to below code

        Log.i(TAG, "Before runBlocking")

        Log.i(TAG, "Start of runBlocking")
        Thread.sleep(5000L)
        Log.i(TAG, "End of runBlocking")

        Log.i(TAG, "After runBlocking")


        // but the only difference is we can actually call suspend functions inside this runBlocking block which we
        // can't do that directly inside Main thread.

        runBlocking {

            // we can also start a new coroutine just by writing launch block inside this runBlocking block.
            launch(Dispatchers.IO) {
                // now this "launch" coroutine will actually run asynchronously to this runBlocking which is launched in the Main thread
                // so it won't be blocked.

                Log.i(TAG, "Starting IO coroutine 1")
                delay(3000L)
                Log.i(TAG, "Finished IO coroutine 1")
            }

            launch(Dispatchers.IO) {

                Log.i(TAG, "Starting IO coroutine 2")
                delay(3000L)
                Log.i(TAG, "Finished IO coroutine 2")
            }

            // so you can see the logs and you'll see after 3 seconds both IO threads will be finished executing
            // so it's not like first IO thread gets executed with 3 sec delay then the second IO thread will get executed with 3 sec delay and it will take total 6 sec to execute 2nd thread
            // instead what will happen is both of which gets executed at the same time with 3sec delay.
        }

    }


}

















