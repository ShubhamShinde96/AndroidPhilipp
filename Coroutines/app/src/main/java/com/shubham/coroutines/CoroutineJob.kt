package com.shubham.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class CoroutineJob : AppCompatActivity() {

//    4

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_job)

        // Whenever we launch a coroutine it returns a job which we can save in a variable.

        val job = GlobalScope.launch(Dispatchers.Default) {

            /*repeat(5) {
                Log.i(TAG, "Coroutine is still working...")
                delay(1000L)
            }*/
            // commented for fibonacci demo

            Log.i(TAG, "Starting long running cancellation...")

            withTimeout(3000L) {

                for (i in 30..40) {
                    if (isActive) {
                        Log.i(TAG, "Result for = i $i: is ${fibonacci(i)}")
                    }
                }
            }

            Log.i(TAG, "Ending long running cancellation...")

            // sometimes we want to cancel coroutine is because timeout, so lets say if we have a network call that
            // takes too much time and you want to cancel it, for that the coroutine comes with very useful function
            // called withTimeout() which we can just wrap around for our long running tasks.
            // see above for loop, we have wrapped it inside our withTimeout(){} block
            // what this means it, if the code inside wrapped block is taking longer than time that we have passed
            // then it will cancel it automatically, without needing us to cancel it manually.

            // now commenting below runBlocking as we have wrapped for loop inside withTimeout block.
            // uncomment it and remove this withTimeout wrapped to see old results.
        }

        // by using job variable we can do many things, like we can wait for it to finish, like a callback
//        job.join() // join() is a suspending function so we have to use it inside coroutine scope

        /*runBlocking {
//            job.join() // this join function will block our thread until coroutine it is referencing to is gets finished.
            // that means here below join if you write any code then it will only execute after above GlobalScope coroutine gets finished executing.
            // So here in log you'll see "Coroutine is still working..." for 5 times
            // and then you'll see "Main thread is continuing now" message


            delay(2000L)
            job.cancel()
            // the result of above code will be: "Coroutine is still working..." will get printed 2 times and then
            // "Main thread is continuing now." will get printed, as we are cancelling this job after 2 seconds.
            // in case of "join()" it holds the current thread until coroutine returned job gets executed, that's the job of join()


            // performing cancel() on any job is not that easy, because before calling it we have to make sure that it is been
            // setup correctly in the first place
            Log.i(TAG, "Cancelled job, Main thread is continuing now.")

            // so after setting up recursive fibonacci fun what happening is coroutine is getting canceled after 2
            // seconds but it is still executing after that
            // the reason is that our coroutine is so busy with the work it has no time to check for the cancellation.
            // so basically we have to manually check if it has been canceled or not. we're doing this inside our
            // for loop in coroutine.
        }*/


    }


    // recursive fibonacci function
    // we are using this function because for larger numbers it takes some time to be executed and with that we can
    // see how that cancellation works if you have a long running job.
    fun fibonacci(n: Int): Long {

        return if (n == 0) 0
        else if (n == 1) 1
        else fibonacci(n - 1) + fibonacci(n - 2) // this fun is recursive, as you can see here, it calls itself
    }

}

















