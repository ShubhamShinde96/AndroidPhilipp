package com.shubham.coroutines.SectionSix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shubham.coroutines.R

class LifecycleAndViewmodelScopeActivity : AppCompatActivity() {

//    6

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_and_viewmodel_scope)

        // most of the time it will be a bad practice to use GlobalScope because we "rarely" need our coroutines
        // to be alive as long as our application and for android there are two very useful predefined scopes
        // which is lifecycle scope and ViewModel scope, to add these we need to include the lifecycle dependencies.



    }



}





























