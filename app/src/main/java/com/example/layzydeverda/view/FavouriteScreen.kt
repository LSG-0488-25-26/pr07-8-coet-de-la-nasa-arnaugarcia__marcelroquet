package com.example.layzydeverda.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.layzydeverda.nav.Routes
import com.example.layzydeverda.viewModel.ApiViewModel
@Composable
fun FavoriteScreen(navController: NavController, viewModel: ApiViewModel) {
    val countries by viewModel.countryList.observeAsState(emptyList())
    val favoriteCountries = countries.filter { it.isFav }

    if (favoriteCountries.isEmpty()) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            EmptyFavoritesMessage(

            )
        }
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        ) {
            items(favoriteCountries) { country ->
                CountryItem(
                    country = country,
                    onItemSelected = {
                        navController.navigate(
                            Routes.CountryDetailScreen.createRoute(it)
                        )
                    },
                    onToggleFavourite = {
                        viewModel.toggleFavourite(it)
                    },
                    dismissable = true
                )
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp
                )
            }
        }
    }
}