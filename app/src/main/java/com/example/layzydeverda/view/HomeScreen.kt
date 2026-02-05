package com.example.layzydeverda.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.layzydeverda.nav.Routes
import com.example.layzydeverda.viewModel.ApiViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: ApiViewModel) {
    val countries by viewModel.countryList.observeAsState(emptyList())

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        items(countries) { country ->
            CountryItem(
                country = country,
                onItemSelected = {
                    navController.navigate(
                        Routes.CountryDetailScreen.createRoute(it)
                    )
                },
                onToggleFavourite = {
                    viewModel.toggleFavourite(it)
                }
            )
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
        }
    }

}