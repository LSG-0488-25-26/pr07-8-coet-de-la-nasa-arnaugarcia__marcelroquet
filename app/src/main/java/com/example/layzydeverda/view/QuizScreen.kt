package com.example.layzydeverda.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.layzydeverda.viewModel.ApiViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun QuizScreen(apiViewModel: ApiViewModel) {
    var country by remember {
        mutableStateOf(apiViewModel.getRandomCountryQuiz())
    }
    val score by apiViewModel.counter.observeAsState(0)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(40.dp)
            ,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Score: $score",
            color = Color.White,
            modifier = Modifier.align(Alignment.TopEnd),
            textAlign = TextAlign.End
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("What country is this flag from?",
                color = Color.White)
            Spacer(modifier = Modifier.height(50.dp))

            GlideImage(
                model = country.flagUrl,
                contentDescription = country.flagUrl,
                modifier = Modifier
                    .height(200.dp)
                    .aspectRatio(1.6f),   // Aspect ratio de bandera normal 16:9
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        apiViewModel.checkAnswer(country, country.answers[0])
                        country = apiViewModel.getRandomCountryQuiz()
                    },
                    modifier = Modifier.weight(1f)
                )
                {
                    Text(
                        text = country.answers[0],
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
                Button(
                    onClick = {
                        apiViewModel.checkAnswer(country, country.answers[1])
                        country = apiViewModel.getRandomCountryQuiz()
                    },
                    modifier = Modifier.weight(1f)
                )
                {
                    Text(
                        text = country.answers[1],
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Button(
                    onClick = {
                        apiViewModel.checkAnswer(country, country.answers[2])
                        country = apiViewModel.getRandomCountryQuiz()
                    },
                    modifier = Modifier.weight(1f)
                )
                {
                    Text(
                        text = country.answers[2],
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
                Button(
                    onClick = {
                        apiViewModel.checkAnswer(country, country.answers[3])
                        country = apiViewModel.getRandomCountryQuiz()
                    },
                    modifier = Modifier.weight(1f)
                )
                {
                    Text(
                        text = country.answers[3],
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        }
    }
}
