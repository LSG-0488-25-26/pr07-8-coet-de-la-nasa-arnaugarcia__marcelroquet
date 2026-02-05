package com.example.layzydeverda.api_room

import com.example.layzydeverda.mapper.returnCountryListToEntityList
import com.example.layzydeverda.model.CountryEntity

class Repository {
    val api = ApiInterface.create()
    val dao = CountryApplication.database.countryDao()

    suspend fun getCountries(): List<CountryEntity> {
        if (dao.count() == 0) {
            val response = api.getCountries()

            if (response.isSuccessful) {
                response.body()?.let {
                    dao.insertAll(returnCountryListToEntityList(it))
                }
            }
        }

        return dao.getAll()
    }
}
