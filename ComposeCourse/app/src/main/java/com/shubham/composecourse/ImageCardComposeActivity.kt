package com.shubham.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubham.composecourse.ui.theme.ComposeCourseTheme

class ImageCardComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val painter = painterResource(id = R.drawable.kermit3)
            val description = "This is a chilling kermit"
            val title = "Kermit is chilling here"
            
            ImageCard(painter = painter, contentDescription = description, title = title)
        }

    }


@Composable
fun ImageCard(
    painter: Painter, // this will allow us to use the image from our image source which is drawable in this particular case.
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier // setting up this for default empty modifier
) {
    
    Card(
        modifier = modifier
            .fillMaxWidth(0.5f)
            .padding(16.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {

        // Whenever we want to design layout where we want to add elements on top of each other in 
        // that case we use Box
        Box(modifier = Modifier.height(200.dp)) {
            // so whatever we put here will be displayed on top of each other
            // and obviously we can still align the items according to our needs.
            // So whatever we put fist element here will be bottom of our layout stack.
            Image(painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f,
                    ))
            )

            // Since we are not using Row or Column here we need to create another box here
            // to align this text to the bottom of our card.
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }

        }
    }
}

}

















