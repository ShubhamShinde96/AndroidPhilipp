package com.shubham.coroutines.SectionSix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.shubham.coroutines.R
import com.shubham.coroutines.databinding.ActivitySectionSixHelperBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SectionSixHelperActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySectionSixHelperBinding

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_section_six_helper)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_six_helper)

        binding.btnStartActivity.setOnClickListener {

            /*GlobalScope.launch {

                while (true) {

                    delay(1000L)
                    Log.d(TAG, "Still running...")
                }
            }

            GlobalScope.launch {

                delay(5000L)

                Intent(this@SectionSixHelperActivity, LifecycleAndViewmodelScopeActivity::class.java).also {
                    startActivity(it)
                    finish()
                }

            }*/

            // so after clicking on button you'll see even though we have started new activity after 6 seconds here
            // and we have also finished this activity but still we're going to see "Still running.." logs
            // that's because we've used GlobalScope and it retains until the lifecycle of our entire application.
            // So it won't be destroyed automatically even though our activity is destroyed.
            // So this case can create MemoryLeaks

            // To solve this problem we should use "lifecycleScope" instead of "GlobalScope", like below ex:

            lifecycleScope.launch {
                // lifecycleScope will just stick this coroutine to the lifecycle of our current activity,
                // that means if the activity is destroyed then all coroutines launched in this lifecycleScope
                // will also be destroyed.

                while (true) {

                    delay(1000L)
                    Log.d(TAG, "Still running...")
                }
            }

            GlobalScope.launch {

                delay(5000L)

                Intent(this@SectionSixHelperActivity, LifecycleAndViewmodelScopeActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }

            // If you now re-run the app you'll see this time after launching new activity and after finishing this
            // activity the infinite while loop will stop executing as the lifecycleScope coroutine that is bound to
            // this current activity will get terminated as soon as this current activity gets destroyed.

            // Keep in mind if "lifecycleScope" coroutine does a long running calculation & doesn't suspend then
            // you must regularly check if it is active, otherwise it can be cancelled because (for reason re-watch
            // coroutine-job video.

            // This "lifecycleScope" will also work with the fragments lifecycle

            // now the "viewModelScope" is also same as the "lifecycleScope" only that it will keep your coroutines
            // alive as long as your "ViewModel" is alive.

        }



    }




}


