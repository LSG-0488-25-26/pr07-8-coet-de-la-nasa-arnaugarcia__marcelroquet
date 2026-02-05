package com.example.layzydeverda.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Public
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationScreens(val route: String,
                                     val icon: ImageVector
){
    object Home: BottomNavigationScreens(Routes.Home.route, Icons.Filled.Public)
    object Favorite: BottomNavigationScreens(Routes.Favorite.route, Icons.Filled.Favorite)
    object Quiz: BottomNavigationScreens(Routes.Quiz.route, Icons.Filled.Flag)
}