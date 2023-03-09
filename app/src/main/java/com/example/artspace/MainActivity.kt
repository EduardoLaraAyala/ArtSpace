package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}
@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    val firstArtwork = R.drawable.barca
    val secondArtwork = R.drawable.messi
    val thirdArtwork = R.drawable.xavi
    val fourthArtwork = R.drawable.puyol
    val fifthArtwork = R.drawable.cruyff

    var title by remember {
        mutableStateOf(R.string.barca)
    }

    var year by remember {
        mutableStateOf(R.string.barca_year)
    }

    var currentArtwork by remember {
        mutableStateOf(firstArtwork)
    }

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtworkDisplay(currentArtwork = currentArtwork)
        Spacer(modifier = modifier.size(16.dp))
        ArtworkTitle(title = title, year = year)
        Spacer(modifier = modifier.size(25.dp))
        Row(
            modifier = modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)

        ) {
            // Previous boton
            Button(
                onClick = {
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = fifthArtwork
                            title = R.string.cruyff
                            year = R.string.trofeos_cruyff
                        }
                        secondArtwork -> {
                            currentArtwork = firstArtwork
                            title = R.string.barca
                            year = R.string.barca_year
                        }
                        thirdArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.messi
                            year = R.string.trofeos_messi
                        }
                        fourthArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.xavi
                            year = R.string.trofeos_xavi
                        }
                        else -> {
                            currentArtwork = fourthArtwork
                            title = R.string.puyol
                            year = R.string.trofeos_puyol
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.blue_700)
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Previous",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }


            // Next boton
            Button(
                onClick = {
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.messi
                            year = R.string.trofeos_messi
                        }
                        secondArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.xavi
                            year = R.string.trofeos_xavi
                        }
                        thirdArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.puyol
                            year = R.string.trofeos_puyol
                        }
                        fourthArtwork -> {
                            currentArtwork = fifthArtwork
                            title = R.string.cruyff
                            year = R.string.trofeos_cruyff
                        }
                        else -> {
                            currentArtwork = firstArtwork
                            title = R.string.barca
                            year = R.string.barca_year
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.blue_700)
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

@Composable
fun ArtworkDisplay(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Image(
        painter = painterResource(currentArtwork),
        contentDescription = stringResource(id = R.string.messi),
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Artwork nombre
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue_700),
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline

        )

        // Artwork trofeos
        Text(
            text = stringResource(id = year),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300),
            textAlign = TextAlign.Center

        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}