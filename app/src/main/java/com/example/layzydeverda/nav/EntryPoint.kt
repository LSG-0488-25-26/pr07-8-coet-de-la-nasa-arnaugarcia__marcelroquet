package com.example.layzydeverda.nav


import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.layzydeverda.view.CountryDetail
import com.example.layzydeverda.view.HomeScreen
import com.example.layzydeverda.viewModel.ApiViewModel

@Composable
fun EntryPoint(navigationController: NavController, viewModel: ApiViewModel) {
    NavHost(
        navController = navigationController as NavHostController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route) {
            HomeScreen(navigationController, viewModel)
        }

        composable(
            Routes.CountryDetailScreen.route,
            arguments = listOf(
                navArgument("countryName") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            CountryDetail(
                navController = navigationController,
                viewModel = viewModel,
                countryName = backStackEntry.arguments?.getString("countryName").orEmpty()
            )
        }
    }
}