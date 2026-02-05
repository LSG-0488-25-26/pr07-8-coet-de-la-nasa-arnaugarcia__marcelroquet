package com.example.layzydeverda.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.layzydeverda.model.CountryEntity

@Dao
interface CountryDAO {
    @Query("SELECT * FROM country ORDER BY name")
    suspend fun getAll(): List<CountryEntity>

    @Query("SELECT * FROM country WHERE is_fav = 1 ")
    fun isFav(): MutableList<CountryEntity>

    @Query("SELECT * FROM country WHERE name LIKE :name")
    fun searchByName(name: String): List<CountryEntity>

    @Insert
    suspend fun insertAll(countries: List<CountryEntity>)

    @Update
    suspend fun updateCountry(country: CountryEntity)

    @Query("SELECT COUNT(*) FROM country")
    suspend fun count(): Int
}