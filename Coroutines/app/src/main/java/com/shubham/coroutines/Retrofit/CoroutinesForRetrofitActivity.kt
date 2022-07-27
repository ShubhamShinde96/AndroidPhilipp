package com.shubham.coroutines.Retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.shubham.coroutines.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory



class CoroutinesForRetrofitActivity : AppCompatActivity() {

    val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_for_retrofit)

        val api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(MyApi::class.java)

        /*api.getComments(1, "comments").enqueue(object : Callback<Comment>{

            override fun onResponse(call: Call<Comment>, response: Response<Comment>) {

                if (response.isSuccessful) {
                    response.body()?.let {
                        for (comment in it) {
                            Log.i(TAG, comment.toString())
                        }
                    }
                }
            }

            override fun onFailure(call: Call<Comment>, t: Throwable) {
                Log.i(TAG, "Error: $t")
            }

        })*/

        // So now here we have started a whole another thread with the "enqueue" function & that is not very
        // efficient, because now we have coroutines which are more efficient way
        // So let's actually use the coroutine for that

        /*GlobalScope.launch(Dispatchers.IO) {

            val comments = api.getComments(1, "comments").await()

            for (comment in comments) {
                Log.i(TAG, comment.toString())
            }
        }*/ // Commented because using suspend function in MyApi.kt interface and returning Response object instead of Call

        // So this is a much simpler and a clean way to do it.
        // but what if we want to get the "response object" of the retrofit request? because await function directly
        // gives us list of comments but in case an error occurs in our request then we cannot really handle it.
        // So for receiving "response object" of retrofit consider following code

        /*GlobalScope.launch(Dispatchers.IO) {

            val response = api.getComments(1, "comments").awaitResponse()

            if(response.isSuccessful) {
                for (comment in response.body()!!) {
                    Log.i(TAG, comment.toString())
                }
            }
        }*/ // Commented because using suspend function in MyApi.kt interface and returning Response object instead of Call


        // So that is one way of using coroutine for retrofit api calls, now another way which is preferred is
        // making our API class interface functions suspendable, open MyApi.kt and make it suspendable

        // Now that we have done the changes in our API interface, we can't use await() or awaitResponse() anymore
        // as we're returning the "Response" object
        // We don't need to use it anymore cause our API interface is already returning the "Response" object.

        GlobalScope.launch(Dispatchers.IO) {

            val response = api.getComments(1, "comments")

            if(response.isSuccessful) {
                for (comment in response.body()!!) {
                    Log.i(TAG, comment.toString())
                }
            }
        }


        // following code was from Retrofit section of android jetpack course, uncompleted here!, as we don't need it right now
        // just keeping it for reference to remember to revisit it again.
//        val responseLiveData: LiveData<Response<Comment>>

    }


}












