package com.shubham.kotlinflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SharedFlowActivity : AppCompatActivity() {

    private lateinit var timerTv: TextView
    private lateinit var incrementBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_flow)

        timerTv = findViewById(R.id.timerTv)
        incrementBtn = findViewById(R.id.incrementBtn)

        // So Shared flow is used to send only one time event, so the emissions are of two types
        // 1] state emission : like state flow, when we rotate our device it will fire up again & notify its collectors

        // so for ex: after login we should navigate to certain fragment only once, that should no happen again when
        // we rotate our device & for these things we use "SharedFlow"
        // search about "channels" android
        // shared flow is also hot flow, so if we send event into it and there are no subscribers(collectors) then
        // the event will be lost (we have not collected it's emitted data), so it won't kept in the flow, means flow will do something even if there are
        // no collectors.
    }


}



































