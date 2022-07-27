package com.shubham.kotlinflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.shubham.kotlinflow.flow_operators.MainViewModelOtherOperators
import com.shubham.kotlinflow.sharedflow_and_stateflow.MainViewModelStateFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var timerTv: TextView
    private lateinit var incrementBtn: Button

//    private lateinit var viewModel: MainViewModelStateFlow // old traditional approch
    private val  viewModel: MainViewModelStateFlow by viewModels()  // by viewModels() require androidx.activity and
    // androidx.fragment dependencies.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerTv = findViewById(R.id.timerTv)
        incrementBtn = findViewById(R.id.incrementBtn)

        // Flow is basically kotlin coroutine that can return multiple values over a period of time
        // Single suspend function or a single coroutine can only return a single value once
        // you can only return one single statement to any coroutine or suspend function, after that function is over

        // but if you want to do something like countdown timer that emits the value every single second then you
        // can't do that with the normal coroutine, & this is where kotlin flows comes into play

//        viewModel = ViewModelProvider(this).get(MainViewModelStateFlow::class.java) // old traditional approch

        // so now we'll get our flow as state

        var time: Int

        /*lifecycleScope.launch {

            val time = viewModel.countdownFlow.collect {
                timerTv.text = it.toString()
                time = it
            }
        }*/ // commented for state flow example

        lifecycleScope.launch {

            // most people think this is enough as we have used lifecycleScope this viewModel.stateFlow will get cancelled
            // considering activity lifecycle, but that actually not the case

            // instead we'll need another block here & that is:
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // now this "repeatOnLifecycle" block will act like aware of lifecycle & the code inside this block
                // will get cancelled or be repeated based upon lifecycle changes of our activity.
                // And that is now the same behaviour as we would get with liveData

                //            viewModel.stateFlow.collect {
                viewModel.stateFlow.collectLatest {

                    Log.d("RECREATION", "Inside stateFlow.collect { it: $it }")

                    timerTv.text = it.toString()
                    time = it
                }
            }
        }

        // So this is actually very much code just to collect a flow from viewModel so instead what we can do is
        // we can create a extension function for it
        // so below is our "collectLatestLifecycleFlow() is our extension function and instead of all above code
        // we'll just use that function like below.
        /*collectLatestLifecycleFlow(viewModel.stateFlow) { number ->
            timerTv.text = number.toString()
        }*/ // commented this function call and keeping the above code instead as we need to understand more regarding it's
        /// high order function.

        // so in this passed param viewModel.stateFlow you can use operators like viewModel.stateFlow.map{ }
        // or viewModel.stateFlow.flatMapConcat { } all the stuff(operators) that we used on other flow
        // and on liveData you don't have that many cool operators & it just use coroutines which is much cooler than
        // live data


        incrementBtn.setOnClickListener {

            viewModel.incrementCounter()
        }


    }

}


fun <T> AppCompatActivity.collectLatestLifecycleFlow(flow: Flow<T>, collect: suspend (T) -> Unit) {

    lifecycleScope.launch {

        repeatOnLifecycle(Lifecycle.State.STARTED) {

            flow.collectLatest(collect)
        }
    }
}