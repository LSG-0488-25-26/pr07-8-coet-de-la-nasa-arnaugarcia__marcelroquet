package com.example.layzydeverda.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.layzydeverda.nav.BottomNavigationScreens

class ScaffoldViewModel : ViewModel {
    private val _bottomNavigationItems = MutableLiveData<List<BottomNavigationScreens>>(emptyList())
    val bottomNavigationItems: LiveData<List<BottomNavigationScreens>> = _bottomNavigationItems

    constructor() : super() {
        this._bottomNavigationItems.value = listOf(
            BottomNavigationScreens.Home,
            BottomNavigationScreens.Favorite,
            BottomNavigationScreens.Quiz
        )
    }
}