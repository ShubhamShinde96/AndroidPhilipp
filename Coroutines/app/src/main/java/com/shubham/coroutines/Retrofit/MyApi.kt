package com.shubham.coroutines.Retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {

    /*@GET("/posts/{id}/{comment}")
    fun getComments(@Path(value = "id") cid: Int, @Path(value = "comment") comment: String): Call<Comment>*/

    // making it suspendable & returning "Response" object instead of "Call" object.
    @GET("/posts/{id}/{comment}")
    suspend fun getComments(@Path(value = "id") cid: Int, @Path(value = "comment") comment: String): Response<Comment>


}