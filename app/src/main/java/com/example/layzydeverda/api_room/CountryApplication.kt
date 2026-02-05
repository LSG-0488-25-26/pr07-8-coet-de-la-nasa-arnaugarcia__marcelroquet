package com.example.layzydeverda.api_room

import android.app.Application
import androidx.room.Room
import com.example.andoidstudio_recyclerview_demo.room.CountryDatabase

class CountryApplication: Application() {
    // Creem un atribut estàtic de la classe
    companion object {
        lateinit var database: CountryDatabase
    }

    override fun onCreate() {
        super.onCreate()
        // Aquí determinem el nom de la base de dades.
        database = Room.databaseBuilder(this, CountryDatabase::class.java,"CountryDatabase").build()
    }
}
