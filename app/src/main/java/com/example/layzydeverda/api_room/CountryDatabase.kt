package com.example.andoidstudio_recyclerview_demo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.layzydeverda.dao.CountryDAO
import com.example.layzydeverda.model.CountryEntity

@Database(entities = [CountryEntity::class], version = 2)
// La classe CharacterDatabase hereta de RoomDatabase
abstract class CountryDatabase: RoomDatabase() {
    abstract fun countryDao(): CountryDAO
}