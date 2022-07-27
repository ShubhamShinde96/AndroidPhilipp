package com.shubham.tmdbclient.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.shubham.tmdbclient.R
import com.shubham.tmdbclient.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@TvShowActivity, R.layout.activity_tv_show)



    }


}

















