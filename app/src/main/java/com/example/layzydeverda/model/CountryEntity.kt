package com.example.layzydeverda.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class CountryEntity(
    @PrimaryKey
    val name: String,
    val capital: String?,
    val region: String,
    val population: Int,
    val flagUrl: String,
    @ColumnInfo(name = "is_fav")
    val isFav: Boolean = false
)
