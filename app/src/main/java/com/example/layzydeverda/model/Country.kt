package com.example.layzydeverda.model
// api: https://restcountries.com/v3.1/all?fields=name,capital,region,population,flags

data class Country(
    val name: String,
    val capital: String,
    val region: String,
    val population: Int,
    val flag: Int
)