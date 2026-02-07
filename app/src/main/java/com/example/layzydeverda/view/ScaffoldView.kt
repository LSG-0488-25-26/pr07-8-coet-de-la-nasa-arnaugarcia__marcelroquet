package com.example.layzydeverda.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.layzydeverda.viewModel.ApiViewModel
import com.example.layzydeverda.viewModel.ScaffoldViewModel

@Composable
fun ScaffoldView(
    scaffoldViewModel: ScaffoldViewModel,
    apiViewModel: ApiViewModel,
    navController: NavHostController
) {
    Scaffold(
        topBar = { MyTopAppBar(navController, scaffoldViewModel, apiViewModel) },
        bottomBar = { MyBottomBar(scaffoldViewModel, navController) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            MyNavHost(navController, apiViewModel)
        }
    }
}
