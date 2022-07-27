package com.shubham.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shubham.composecourse.ui.theme.ComposeCourseTheme

class ModifiersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
//                    .padding(16.dp) // ctrl + p inside () to know more about params
//                    .padding(top = 50.dp)
                    .border(5.dp, Color.Magenta)
                    .padding(5.dp)
                    .border(5.dp, Color.Blue)
                    .padding(5.dp)
                    .border(10.dp, Color.Red)
                    .padding(10.dp)
//                    .width(3600.dp)
//                    .requiredWidth(600.dp)
            ) {
                Text(text = "Hello", modifier = Modifier // in compose we don't have margin. padding is enough to do what we used to do with padding and margin combined.
                    .clickable {  }
//                    .offset(0.dp, 20.dp)
//                    .border(5.dp, Color.Yellow)
//                    .offset(20.dp, 20.dp)
//                    .border(10.dp, Color.Black)
//                    .padding(10.dp)
                    ) // offset does the same thing as margin but it wont push other elements in any ways.
                // offset always starts with top left corner of composable.
                // Now to push down other elements and avoid overlapping we can use spacer like below.

                    Spacer(modifier = Modifier.height(50.dp))

                Text(text = "World")
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    ComposeCourseTheme {
        Greeting2("Android")
    }
}