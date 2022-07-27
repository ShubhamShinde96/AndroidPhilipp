package com.shubham.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*

class CoroutineContextsActivity : AppCompatActivity() {

    // 2

    val TAG = "MainActivity"

    private lateinit var tvDummy: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_contexts)

        tvDummy = findViewById(R.id.tvDummy)

        // So coroutines are always started in a specific context and the context will describe in which thread that
        // coroutine will be started in

        GlobalScope.launch(Dispatchers.IO) {

            Log.i(TAG, "Starting coroutine in ${Thread.currentThread().name}")

//            Dispatchers.Main // For main thread, for performing UI operations.
//            Dispatchers.IO    // for data operations such as making a network call or performing database operations or reading and writing to files.
//            Dispatchers.Default   // use this if you're planning on doing complex and long running calculations that could block the main thread.
//            Dispatchers.Unconfined    // it is not bound to specific thread, so if you start a coroutine with unconfined and that calls a suspend function then it will stay in the thread that suspend function resumed
//            newSingleThreadContext("ShubhamsThread") // this way we can define our own thread
//
            // so suppose if you're making a network call then you'll obviously do that in IO thread, consider the below line for network call
            val answer = doNetworkCall()
            // now you'll(execution) arrive at this current line after network call is happened/executed.
            // now you'll want to update your UI based on result from network call
            // So now for making UI operation we need to switch to the Main dispatched (Main Thread) and you can do that, consider following line for that.
            withContext(Dispatchers.Main) {
                // now code inside of this block will now executed in a Main thread.
                tvDummy.text = answer

                Log.i(TAG, "Setting text in thread: ${Thread.currentThread().name}")
            }

        }

    }

    suspend fun doNetworkCall(): String {

        delay(3000)

        return "This is the answer"
    }

}



















