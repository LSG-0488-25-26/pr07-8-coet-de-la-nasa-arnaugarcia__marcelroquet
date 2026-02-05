package com.example.layzydeverda.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.layzydeverda.nav.Routes
import com.example.layzydeverda.viewModel.ApiViewModel
import com.example.layzydeverda.viewModel.ScaffoldViewModel

@Composable
fun MyNavHost(
    navController: NavHostController,
    apiViewModel: ApiViewModel,
) {
    val loading by apiViewModel.loading.observeAsState(true)

    LaunchedEffect(Unit) {
        apiViewModel.getAllCountries()
    }
    if (loading) {
        Text("Cargando")
    } else {
        NavHost(
            navController = navController,
            startDestination = Routes.Home.route // Definim la pantalla inicial
        ) {
            composable(Routes.Home.route) { HomeScreen(navController, apiViewModel) }
            composable(Routes.Favorite.route) { FavoriteScreen(navController, apiViewModel) }
            composable(Routes.Quiz.route) { QuizScreen(apiViewModel) }

            composable(
                Routes.CountryDetailScreen.route,
                arguments = listOf(
                    navArgument("countryName") {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                CountryDetail(
                    navController = navController,
                    viewModel = apiViewModel,
                    countryName = backStackEntry.arguments?.getString("countryName").orEmpty()
                )
            }
        }
    }
}