package com.shubham.daggerhilt

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.shubham.daggerhilt.domain.repository.MyRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint // need to annotate because service is an android component class.
class MyService
//@Inject constructor(private val repository: MyRepository)
    : Service() {

    // lets say we need our repository interface here, so you'll expect this param inside MyService constructor but
    // however that does not work because you can't give service a constructor.
    // How can we then still get our repository inside this service?

    // Well the answer is using field injection, that is also a thing that we can simply have lateinit variables
    @Inject
    lateinit var repository: MyRepository

    override fun onCreate() {
        super.onCreate()

        GlobalScope.launch(Dispatchers.IO) {
            repository.doNetworkCall()
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

}