package com.example.layzydeverda.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// api: https://restcountries.com/v3.1/all?fields=name,capital,region,population,flags

data class Country(
    val name: Name,
    val capital: List<String>,
    val region: String,
    val population: Int,
    val flags: Flags,
    val isFav: Boolean = false
)

data class Flags(
    val png: String
)

data class Name (
    val common: String
)