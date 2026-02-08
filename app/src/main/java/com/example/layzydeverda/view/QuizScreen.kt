package com.example.layzydeverda.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.layzydeverda.viewModel.ApiViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun QuizScreen(apiViewModel: ApiViewModel) {

    var country by remember { mutableStateOf(apiViewModel.getRandomCountryQuiz()) }
    val score by apiViewModel.counter.observeAsState(0)

    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(24.dp)
    ) {

        Text(
            text = "Score: $score",
            color = Color.White,
            modifier = Modifier.align(Alignment.TopEnd)
        )

        if (isLandscape) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                GlideImage(
                    model = country.flagUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .weight(0.5f)
                        .aspectRatio(1.6f),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(24.dp))

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "What country is this flag from?",
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            onClick = {
                                apiViewModel.checkAnswer(country, country.answers[0])
                                country = apiViewModel.getRandomCountryQuiz()
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                country.answers[0],
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))

                        Button(
                            onClick = {
                                apiViewModel.checkAnswer(country, country.answers[1])
                                country = apiViewModel.getRandomCountryQuiz()
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                country.answers[1],
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            onClick = {
                                apiViewModel.checkAnswer(country, country.answers[2])
                                country = apiViewModel.getRandomCountryQuiz()
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                country.answers[2],
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))

                        Button(
                            onClick = {
                                apiViewModel.checkAnswer(country, country.answers[3])
                                country = apiViewModel.getRandomCountryQuiz()
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                country.answers[3],
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        }
                    }
                }
            }

        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    "What country is this flag from?",
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(24.dp))

                GlideImage(
                    model = country.flagUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .aspectRatio(1.6f),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = {
                            apiViewModel.checkAnswer(country, country.answers[0])
                            country = apiViewModel.getRandomCountryQuiz()
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            country.answers[0],
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = {
                            apiViewModel.checkAnswer(country, country.answers[1])
                            country = apiViewModel.getRandomCountryQuiz()
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            country.answers[1],
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = {
                            apiViewModel.checkAnswer(country, country.answers[2])
                            country = apiViewModel.getRandomCountryQuiz()
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            country.answers[2],
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = {
                            apiViewModel.checkAnswer(country, country.answers[3])
                            country = apiViewModel.getRandomCountryQuiz()
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            country.answers[3],
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}