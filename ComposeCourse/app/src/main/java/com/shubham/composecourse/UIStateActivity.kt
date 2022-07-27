package com.shubham.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.shubham.composecourse.ui.theme.ComposeCourseTheme
import kotlin.random.Random

class UIStateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(Modifier.fillMaxSize()) {

                val color = remember {
                    mutableStateOf(Color.Yellow)
                }

                ColorBox(
                    Modifier
                        .weight(1f)
                        .fillMaxSize()
                ) {
                    color.value = it
                }

                Box(modifier = Modifier
                    .background(color = color.value)
                    .weight(1f)
                    .fillMaxSize()
                )
                {

                }
            }

        }
    }


}


@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit // Creating the callback function to change the state of parent composable
) {

    /*val color = remember {  // this lambda function will remember the value
        // from the last composition. because when this get recomposed
        // we'll get the initial value again, so it is necessary to remember
        // the last composition state.
        mutableStateOf(Color.Yellow)
    }*/

    Box(modifier = modifier
//        .background(color.value)
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )

            /*color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )*/
        })
}

