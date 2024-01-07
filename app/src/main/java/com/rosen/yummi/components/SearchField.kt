package com.rosen.yummi.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rosen.yummi.R
import com.rosen.yummi.ui.theme.TextBlack
import com.rosen.yummi.ui.theme.TransparentWhite
import com.rosen.yummi.ui.theme.YummiTheme

@Composable
fun SearchField(
    modifier: Modifier,
    value: String,
    hint : String = "Search",
    onValueChange: (String) -> Unit
) {
    var isHintDisplayed by remember { mutableStateOf(value.isEmpty()) }

    TextField(
        value = value,
        onValueChange = {
            onValueChange(it)
            isHintDisplayed = it.isEmpty()
        },
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(TransparentWhite),
        textStyle = LocalTextStyle.current.copy(color = TextBlack),
        placeholder = {
            if (isHintDisplayed) {
                Text(
                    text = hint,
                    color = TextBlack,
                    fontWeight = FontWeight.Normal
                )
            }
        },
        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.search), contentDescription = null, modifier = Modifier.size(24.dp), tint = TextBlack)
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = TransparentWhite,
            unfocusedContainerColor = TransparentWhite
        )
    )
}

@Preview
@Composable
fun SearchTextFieldPreview() {
    YummiTheme {
        var textValue by remember { mutableStateOf("") }
        SearchField(modifier = Modifier, value = textValue, onValueChange = { textValue = it })
    }
}