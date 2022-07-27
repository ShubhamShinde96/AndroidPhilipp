package com.shubham.sharedviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.shubham.sharedviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        navController = findNavController(R.id.nav_graph)
//
//        setupActionBarWithNavController(navController)

    }


    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
//        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}
































