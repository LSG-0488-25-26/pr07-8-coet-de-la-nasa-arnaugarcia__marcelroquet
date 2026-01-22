package com.example.layzydeverda.nav

import com.example.layzydeverda.model.Name

sealed class Routes(val route: String) {
    object CountryListScreen : Routes("CountryListScreen")
    object CountryDetailScreen : Routes("CountryDetailScreen/{countryName}") {
        fun createRoute(countryName: Name) = "CountryDetailScreen/$countryName"
    }
}