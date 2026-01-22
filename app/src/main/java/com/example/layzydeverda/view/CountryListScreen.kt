package com.example.lazy_loading.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.layzydeverda.nav.Routes
import com.example.layzydeverda.viewModel.ApiViewModel

@Composable
fun CountryList(navController: NavController, viewModel: ApiViewModel) {
    val countries by viewModel.countryList.observeAsState(emptyList())
    val loading by viewModel.loading.observeAsState(true)

    androidx.compose.runtime.LaunchedEffect(Unit) {
        viewModel.getAllCountries()
    }
    if (loading){
        Text("Cargando")
    } else{
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .padding(vertical = 30.dp)
                .fillMaxWidth()
        ) {
            items(countries) { country ->
                CountryItem(country = country) {
                    navController.navigate(Routes.CountryDetailScreen.createRoute(country.name))
                }
            }
        }

    }


}