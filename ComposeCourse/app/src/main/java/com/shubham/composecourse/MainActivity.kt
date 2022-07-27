package com.shubham.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*ComposeCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }*/
            
//            Text(text = "Hello")
//            Text(text = "World")

            Row(
                modifier = //Modifier.fillMaxSize(0.5f) // default is 1f, that is full, we can set like 0.5f for half size
                    Modifier.width(200.dp)//.height(300.dp)
                        .fillMaxHeight(0.7f)
                    .background(Color.Green),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceAround
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround

                // Remember the Main Access & Cross Access

            ) {
                Text(text = "Hello")
                Text(text = "World")
                Text(text = "Shubham")
            }
            
//            Greeting(name = "Shubham")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    /*ComposeCourseTheme {
        Greeting("Android")
    }*/


    
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Hello")
        Text(text = "World")
    }

//    Greeting("Shubham")
}