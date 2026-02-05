package com.example.layzydeverda.nav

import com.example.layzydeverda.model.Name

sealed class Routes(val route: String) {
    object Home : Routes("CountryListScreen")
    object CountryDetailScreen : Routes("CountryDetailScreen/{countryName}") {
        fun createRoute(countryName: String) = "CountryDetailScreen/$countryName"
    }
    object Quiz : Routes("quiz")
    object Favorite : Routes("favorite")

    object Search : Routes("search")
}