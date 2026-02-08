package com.example.layzydeverda.view

import androidx.compose.material3.Card
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.DismissDirection
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.SwipeToDismiss
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.layzydeverda.model.CountryEntity

@OptIn(
    ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterialApi::class
)
@Composable
fun CountryItem(
    country: CountryEntity,
    onItemSelected: (String) -> Unit,
    onToggleFavourite: (CountryEntity) -> Unit,
    dismissable: (Boolean) = false // Predefinit que no es pugui
) {
    //https://proandroiddev.com/swipe-to-dismiss-jetpack-compose-f874c65cfd95
    val dismissState = rememberDismissState(
        // mai es borri realmentchi
        confirmStateChange = { false }
    )

    LaunchedEffect(dismissState.targetValue) {
        if (dismissState.targetValue == DismissValue.DismissedToStart) {
            // Li passem al pare
            onToggleFavourite(country)
            // Resetegem on estava el country, no el borrem
            dismissState.reset()
        }
    }

    SwipeToDismiss(
        state = dismissState,
        // Només es pot swipear a l'esquerra
        directions = setOf(DismissDirection.EndToStart),
        dismissThresholds = { FractionalThreshold(0.4f) },
        background = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        // Fer gradient horitzontal
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color.LightGray, Color.DarkGray)
                        )
                    )
                    .padding(8.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                when {
                    dismissable -> Icon(Icons.Filled.Delete, contentDescription = "Delete", tint = Color.White)
                    country.isFav -> Icon(Icons.Filled.Favorite, contentDescription = "Fav", tint = Color.White)
                    else -> Icon(Icons.Filled.FavoriteBorder, contentDescription = "Not Fav", tint = Color.White)
                }
            }
        },
        dismissContent = {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.DarkGray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemSelected(country.name) }
                    .height(70.dp),
                shape = RectangleShape,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 8.dp)
                ) {
                    GlideImage(
                        model = country.flagUrl,
                        contentDescription = country.flagUrl,
                        modifier = Modifier
                            .height(40.dp)
                            .aspectRatio(1.6f),   // Aspect ratio de bandera normal 16:9
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(12.dp))
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = country.name,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "Capital: ${country.capital}",
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            color = Color.White
                        )
                    }
                }
            }
        }
    )
}