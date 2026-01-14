package com.example.lazy_loading.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.layzydeverda.model.Country
import com.example.layzydeverda.model.CountryList


class ApiViewModel : ViewModel() {

    private val _cList = CountryList()
    //privat i modificable en el VM
    private val _countries = MutableLiveData<List<Country>>(_cList.getCountries())
    //public pero no modificable
    val countries: LiveData<List<Country>> = _countries

}