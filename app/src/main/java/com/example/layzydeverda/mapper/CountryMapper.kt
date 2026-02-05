package com.example.layzydeverda.mapper

import com.example.layzydeverda.model.Country
import com.example.layzydeverda.model.CountryEntity

fun returnCountryToEntity(country: Country): CountryEntity {
    return CountryEntity(
        name = country.name.common,
        capital = country.capital.firstOrNull(),
        region = country.region,
        population = country.population,
        flagUrl = country.flags.png
    )
}

fun returnCountryListToEntityList(countryList: List<Country>): List<CountryEntity> {
    return countryList.map { returnCountryToEntity(it) }
}
