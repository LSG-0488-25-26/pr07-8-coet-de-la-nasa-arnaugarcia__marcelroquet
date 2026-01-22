package com.example.layzydeverda.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.layzydeverda.model.Country
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.util.Log
import com.example.layzydeverda.api.Repository

class ApiViewModel : ViewModel() {
    private val repository = Repository()
    private val _loading = MutableLiveData(true)
    val loading = _loading
    private val _countryList = MutableLiveData<List<Country>>()
    val countryList : LiveData<List<Country>> = _countryList

    fun getAllCountries() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getCountries()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    _countryList.value = response.body()
                    _loading.value = false

                } else {
                    Log.e("Error :", response.message())
                }
            }
        }
    }
}