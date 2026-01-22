package com.example.layzydeverda.api

class Repository {
    val apiInterface = ApiInterface.create()
    suspend fun getCountries() = apiInterface.getCountries()
}