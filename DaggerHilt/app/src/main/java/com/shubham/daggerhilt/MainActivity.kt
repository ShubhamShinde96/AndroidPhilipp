package com.shubham.daggerhilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.shubham.daggerhilt.ui.theme.DaggerHiltTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // this is needed because we inject dependency here in an android component class.
// android activity component can be a activity, fragment or a service
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel = hiltViewModel<MyViewModel>()

            // hiltViewModel() is a dependency that comes from dagger-hilt which will scope the
            // view-model to the current navigation graph.
            // So whatever graph you have, the view-model will live as long as the graph
            // is active.
            // In this particular case we don't have the navigation graph so it will scope to
            // our MainActivity.
        }

    }

}

