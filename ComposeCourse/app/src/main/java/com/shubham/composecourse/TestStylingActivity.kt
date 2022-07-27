package com.shubham.composecourse

import android.os.Bundle
import android.text.style.StrikethroughSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.shubham.composecourse.ui.theme.ComposeCourseTheme

class TestStylingActivity : ComponentActivity() {

    // 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fontFamily = FontFamily(
            Font(R.font.lexend_thin, weight = FontWeight.Thin),
            Font(R.font.lexend_light, weight = FontWeight.Light),
            Font(R.font.lexend_regular, weight = FontWeight.Normal),
            Font(R.font.lexend_medium, weight = FontWeight.Medium),
            Font(R.font.lexend_semi_bold, weight = FontWeight.SemiBold),
            Font(R.font.lexend_bold, weight = FontWeight.Bold),
            Font(R.font.lexend_extra_bold, weight = FontWeight.ExtraBold),
        )

        setContent {

            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF101010))) {
                    
                Text(
//                    text = "Jetpack Compose",
                    text = buildAnnotatedString {

                                                withStyle(
                                                    style = SpanStyle(
                                                        color = Color.Green,
                                                        fontSize = 50.sp
                                                    )
                                                ) {
                                                    append("J")
                                                }
                        append("etpack ")

                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 50.sp
                            )
                        ) {
                            append("C")
                        }

                        append("ompose")

                    },
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )
            }
            
        }
    }


}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeCourseTheme {
        Greeting3("Android")
    }
}