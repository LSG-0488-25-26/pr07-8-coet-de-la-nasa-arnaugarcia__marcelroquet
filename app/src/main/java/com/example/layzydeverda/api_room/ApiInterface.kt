package com.example.layzydeverda.api_room

import com.example.layzydeverda.model.Country
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("all?fields=name,capital,region,population,flags")
    suspend fun getCountries(): Response<List<Country>>
    companion object {
        val BASE_URL = "https://restcountries.com/v3.1/"
        fun create(): ApiInterface {
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}