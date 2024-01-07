package com.rosen.yummi

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rosen.yummi.ui.theme.Black
import com.rosen.yummi.ui.theme.Green
import com.rosen.yummi.ui.theme.LighterGray
import com.rosen.yummi.ui.theme.YummiTheme

@Composable
fun RecipeDetails(recipeId: String?) {

    YummiTheme {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                val window = (view.context as Activity).window
                window.statusBarColor = Black.toArgb()
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Black)
            ) {
                DetailsHeader()
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Porridge with yogurt and fruits",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 100.dp),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color(0xFFF4F3F3),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))
                RecipeImage()

                Spacer(modifier = Modifier.height(16.dp))
                RecipeDirections()
            }


            Button(
                onClick = { /* Handle button click */ },
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.BottomCenter)
                    .padding(vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Black
                )
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    text = "Start cooking",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        fontSize = 18.sp
                    ),
                )
            }
        }
    }

}

@Composable
fun RecipeDirections() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .background(
                color = Green,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            item {
                Text(
                    text = "Directions",
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color(0xFFF4F3F3),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "Step 1",
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color(0xFFF4F3F3),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "To prepare oatmeal porridge with yogurt, it is better to use oatmeal flakes of prolonged cooking, in which case the porridge turns out tastier and healthier.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color(0xFFF4F3F3),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    textAlign = TextAlign.Center
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "Step 2",
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color(0xFFF4F3F3),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "Combine oats, banana, cinnamon, and salt in a microwave-safe bowl; add water and stir. Cook in microwave until water is absorbed, 2 to 3 minutes. Stir to evenly distribute cinnamon; let stand until slightly cooled, about 3 minutes.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color(0xFFF4F3F3),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }

    }

}

@Composable
fun RecipeImage() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(start = 24.dp, end = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column {
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .background(
                        color = Color.White.copy(alpha = 0.4f),
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 4.dp),
                    text = "15min",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = LighterGray,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light
                    ),
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .background(
                        color = Color.White.copy(alpha = 0.4f),
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 4.dp),
                    text = "80kcal",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = LighterGray,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light
                    ),
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .background(
                        color = Color.White.copy(alpha = 0.4f),
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 4.dp),
                    text = "3 steps",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = LighterGray,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light
                    ),
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .background(
                        color = Color.White.copy(alpha = 0.4f),
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 4.dp),
                    text = "1 person",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = LighterGray,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light
                    ),
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(x = 80.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.recipe5),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun DetailsHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(id = R.drawable.back),
            contentDescription = null,
            tint = LighterGray,
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = "Recipe",
            modifier = Modifier.padding(horizontal = 24.dp),
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color(0xFFF4F3F3),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
        )

        Icon(
            painter = painterResource(id = R.drawable.heart),
            contentDescription = null,
            tint = LighterGray,
            modifier = Modifier.size(32.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailsPreview() {
    YummiTheme {
        RecipeDetails("")
    }
}