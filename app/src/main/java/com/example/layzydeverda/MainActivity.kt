package com.example.layzydeverda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.layzydeverda.ui.theme.LayzyDeVerdaTheme
import com.example.layzydeverda.view.ScaffoldView
import com.example.layzydeverda.viewModel.ApiViewModel
import com.example.layzydeverda.viewModel.ScaffoldViewModel

import kotlin.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apiViewModel by viewModels<ApiViewModel>()
        val scaffoldViewModel by viewModels<ScaffoldViewModel>()
        enableEdgeToEdge()

        setContent {
            LayzyDeVerdaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    ScaffoldView(scaffoldViewModel, apiViewModel, navigationController)
                }
            }
        }
    }
}


