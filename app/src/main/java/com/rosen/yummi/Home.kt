package com.rosen.yummi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rosen.yummi.components.NavBar
import com.rosen.yummi.components.SearchField
import com.rosen.yummi.ui.theme.Black
import com.rosen.yummi.ui.theme.CyanShade
import com.rosen.yummi.ui.theme.Green
import com.rosen.yummi.ui.theme.LighterGray
import com.rosen.yummi.ui.theme.TextBlack
import com.rosen.yummi.ui.theme.TransparentWhite
import com.rosen.yummi.ui.theme.YummiTheme

@Composable
fun Home(navController: NavController) {

    var textValue by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = CyanShade)
        ) {

            Header()

            Spacer(modifier = Modifier.height(16.dp))

            SearchField(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                value = textValue,
                hint = "Search Recipes",
                onValueChange = { textValue = it }
            )

            Spacer(modifier = Modifier.height(10.dp))

            Categories()

            Spacer(modifier = Modifier.height(10.dp))

            RecipesGrid(navController)
        }

        NavBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )

    }

}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Being healthy is easy!",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
        )

        Icon(
            painter = painterResource(id = R.drawable.filter),
            contentDescription = null,
            tint = Green,
            modifier = Modifier.size(32.dp)
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Categories() {
    val categories = listOf("All", "Breakfast", "Salad", "Dinner")

    var selectedItem by remember {
        mutableStateOf(categories[1])
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        itemsIndexed(categories) { index, label ->
            FilterChip(
                modifier = Modifier
                    .padding(start = if (index > 0) 10.dp else 0.dp),
                selected = (label == selectedItem),
                onClick = {
                    selectedItem = label
                },
                label = {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 6.dp, vertical = 6.dp),
                        text = label,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Normal,
                            fontSize = 18.sp
                        ),
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = TransparentWhite,
                    selectedContainerColor = Green,
                    selectedLabelColor = LighterGray,
                    labelColor = TextBlack
                ),
                shape = RoundedCornerShape(20.dp),
                border = FilterChipDefaults.filterChipBorder(
                    borderWidth = 0.dp,
                    borderColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
fun RecipesGrid(navController: NavController) {

    val recipes : MutableList<Recipe> = mutableListOf()
    recipes.add(Recipe(imageResId = R.drawable.recipe2, name = "Porridge with yogurt and fruits", duration = "15min", calories = "80kcal", color = Color(0xFF05B874)))
    recipes.add(Recipe(imageResId = R.drawable.recipe9, name = "Pancakes with ricotta", duration = "25min", calories = "234kcal", color = Color(0xFFEB24A5)))
    recipes.add(Recipe(imageResId = R.drawable.recipe8, name = "Eggs toast with tomatoes", duration = "10min", calories = "134kcal", color = Color(0xFFFF5F1B)))
    recipes.add(Recipe(imageResId = R.drawable.recipe4, name = "Avocado toasts with tomatoes", duration = "23min", calories = "148kcal", color = Color(0xFF7341C8)))

    LazyVerticalGrid(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        columns = GridCells.Fixed(2)
    ) {
        itemsIndexed(recipes) { _, recipe ->
            RecipeItem(
                navController = navController,
                imageResId = recipe.imageResId,
                category = recipe.name,
                duration = recipe.duration,
                calories = recipe.calories,
                color = recipe.color
            )
        }
    }
}

data class Recipe(
    val imageResId: Int,
    val name: String,
    val duration: String,
    val calories: String,
    val color: Color
)

@Composable
fun RecipeItem(
    navController: NavController,
    imageResId: Int,
    category: String,
    duration: String,
    calories: String,
    color: Color
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = false),
                onClick = {
                    navController.navigate("recipe_detail/1")
                }
            ),
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        shape = RoundedCornerShape(24.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = category,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = LighterGray,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light
                    ),
                    textAlign = TextAlign.Center
                )

            }

            Spacer(modifier = Modifier.height(4.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
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
                            .padding(horizontal = 8.dp, vertical = 2.dp),
                        text = duration,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = LighterGray,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Light
                        ),
                    )

                }

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
                            .padding(horizontal = 8.dp, vertical = 2.dp),
                        text = calories,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = LighterGray,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Light
                        ),
                    )

                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    YummiTheme {
        val navController = rememberNavController()
        Home(navController = navController)
    }
}