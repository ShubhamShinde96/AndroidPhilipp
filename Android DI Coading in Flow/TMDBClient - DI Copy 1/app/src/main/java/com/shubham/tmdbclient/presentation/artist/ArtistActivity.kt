package com.shubham.tmdbclient.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.shubham.tmdbclient.R
import com.shubham.tmdbclient.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@ArtistActivity, R.layout.activity_artist)
    }
}