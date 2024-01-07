package com.rosen.yummi.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rosen.yummi.R
import com.rosen.yummi.ui.theme.CyanShade
import com.rosen.yummi.ui.theme.Green
import com.rosen.yummi.ui.theme.TextBlack
import com.rosen.yummi.ui.theme.YummiTheme

@Composable
fun NavBar(
    modifier: Modifier
) {

    Box(
        modifier = modifier
            .wrapContentWidth()
            .padding(vertical = 16.dp)
            .background(color = Color.White.copy(alpha = 0.5f), shape = RoundedCornerShape(48.dp))
    ) {
        Row(
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(color = Green, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.chef),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(color = CyanShade, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    tint = TextBlack,
                    modifier = Modifier.size(30.dp)
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(color = CyanShade, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = null,
                    tint = TextBlack,
                    modifier = Modifier.size(30.dp)
                )
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun NavBarPreview() {
    YummiTheme {
        NavBar(modifier = Modifier)
    }
}