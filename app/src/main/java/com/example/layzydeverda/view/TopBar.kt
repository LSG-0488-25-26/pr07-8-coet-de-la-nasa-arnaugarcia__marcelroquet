package com.example.layzydeverda.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.layzydeverda.viewModel.ApiViewModel
import com.example.layzydeverda.viewModel.ScaffoldViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    navController: NavHostController,
    scaffoldViewModel: ScaffoldViewModel,
    apiViewModel: ApiViewModel
) {
    var searchActive by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "Barra superior") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.DarkGray,
            titleContentColor = Color.DarkGray,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
                searchActive = false
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Enrere"
                )
            }
        },
        actions = {
            if (!searchActive) {
                IconButton(onClick = { searchActive = true }) {
                    Icon(Icons.Filled.Search, contentDescription = "Buscar")
                }
            }
        }
    )
    if (searchActive) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            MySearchBar(
                apiViewModel = apiViewModel,
                closeSearchBar = { searchActive = false }
            )
        }
    }
}

