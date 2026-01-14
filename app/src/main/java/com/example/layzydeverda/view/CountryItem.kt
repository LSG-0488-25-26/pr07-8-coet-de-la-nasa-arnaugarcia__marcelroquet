package com.example.lazy_loading.view

import androidx.compose.material3.Card
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import com.example.layzydeverda.model.Country
@Composable
fun CountryItem(country: Country, onItemSelected: (String) -> Unit) {
    Card(
        border = BorderStroke(1.dp, androidx.compose.ui.graphics.Color.LightGray),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(country.name) }
            .padding(8.dp)
            .height(100.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = country.flag),
                contentDescription = "Flag of ${country.name}",
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = country.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Capital: ${country.capital}",
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                )
            }
        }
    }
}