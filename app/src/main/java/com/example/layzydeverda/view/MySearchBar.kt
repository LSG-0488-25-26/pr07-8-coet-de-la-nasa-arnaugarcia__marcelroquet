package com.example.layzydeverda.view


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.layzydeverda.viewModel.ApiViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySearchBar(
    apiViewModel: ApiViewModel,
    closeSearchBar: () -> Unit
    ) {
    val searchedText by apiViewModel.searchedText.observeAsState("")

    SearchBar(
        query = searchedText,
        onQueryChange = { apiViewModel.onSearchTextChange(it) },
        onSearch = {},
        active = false,
        onActiveChange = { },
        leadingIcon = {
            IconButton(onClick = { closeSearchBar() }) {
                Icon(imageVector = Icons.Filled.Clear, contentDescription = "Clear")
            }
        },
        trailingIcon = {
            if (searchedText.isNotEmpty()) {
                IconButton(onClick = { apiViewModel.onSearchTextChange("") }) {
                    Icon(imageVector = Icons.Filled.Clear, contentDescription = "Clear")
                }
            }
        },
        placeholder = { Text("Search country") },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp)
    ) {}
}