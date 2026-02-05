package com.example.layzydeverda.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.lifecycle.viewModelScope
import com.example.layzydeverda.api_room.Repository
import com.example.layzydeverda.model.CountryEntity
import com.example.layzydeverda.model.Question
import kotlinx.coroutines.CoroutineScope

class ApiViewModel : ViewModel() {
    private val repository = Repository()
    private val _loading = MutableLiveData(true)
    val loading = _loading

    // Llista raw de per a comparar amb la que s'ha de mostrar quan es fa búsqueda
    private var apiCountryList: List<CountryEntity> = emptyList()
    private val _countryList = MutableLiveData<List<CountryEntity>>()
    val countryList: LiveData<List<CountryEntity>> = _countryList
    private val _searchedText = MutableLiveData("")
    val searchedText: LiveData<String> = _searchedText
    private val _counter = MutableLiveData(0)

    val counter: LiveData<Int> = _counter

    fun getAllCountries() {
        // Per alguna raó amb coroutine no deixa
        viewModelScope.launch {
            val countries = withContext(Dispatchers.IO) {
                repository.getCountries()
            }

            apiCountryList = countries
            clearCountries()

            _loading.value = false
        }
    }

    fun clearCountries() {
        apiCountryList = apiCountryList
            .filter {
                it.name != "Antarctica" &&
                        it.name != "Israel"
            }

        _countryList.value = apiCountryList
    }

    fun toggleFavourite(country: CountryEntity) {
        val updatedCountry = country.copy(isFav = !country.isFav)

        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.IO) {
                repository.dao.updateCountry(updatedCountry)
            }
        }

        apiCountryList = apiCountryList.map { c ->
            if (c.name == updatedCountry.name) updatedCountry else c
        }

        _countryList.value = apiCountryList
    }

    fun onSearchTextChange(text: String) {
        _searchedText.value = text
        val query = text.trim()

        if (query.isEmpty()) {
            _countryList.value = apiCountryList
        } else {
            _countryList.value = apiCountryList.filter {
                it.name.contains(query, ignoreCase = true)
            }
        }
    }

    fun getRandomCountryQuiz(): Question {
        val randomCountry: CountryEntity = apiCountryList.random()

        val answers = listOf(
            randomCountry.name,
            apiCountryList.random().name,
            apiCountryList.random().name,
            apiCountryList.random().name
        )

        val randomQuestion = Question(
            name = randomCountry.name,
            flagUrl = randomCountry.flagUrl,
            answers = answers.shuffled()
        )

        return randomQuestion
    }

    fun checkAnswer(question: Question, answer: String) {
        if (question.name == answer) _counter.value = _counter.value + 1
    }
}