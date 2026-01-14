package com.example.layzydeverda.nav

sealed class Routes(val route: String) {
    object CountryListScreen : Routes("CountryListScreen")
    object CountryDetailScreen : Routes("CountryDetailScreen/{countryName}") {
        fun createRoute(countryName: String) = "CountryDetailScreen/$countryName"
    }
}