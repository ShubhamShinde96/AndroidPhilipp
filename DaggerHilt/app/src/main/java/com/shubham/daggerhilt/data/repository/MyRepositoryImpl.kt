package com.shubham.daggerhilt.data.repository

import android.app.Application
import com.shubham.daggerhilt.R
import com.shubham.daggerhilt.data.remote.MyApi
import com.shubham.daggerhilt.domain.repository.MyRepository
import javax.inject.Inject


class MyRepositoryImpl @Inject constructor(  // used @Inject constructor because of RepositoryModel @Bind abstract
    private val api: MyApi,
    private val applicationContext: Application
): MyRepository {

    init {
        val appName = applicationContext.getString(R.string.app_name)
        println("Hello from the repository. The app name is $appName")
    }

    override suspend fun doNetworkCall() {


    }

}