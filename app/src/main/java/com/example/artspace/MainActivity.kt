package com.example.artspace

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}


@Composable
fun MainContainer(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var position by remember { mutableStateOf(0) }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ItemArt(
            image = getItems(context)[position].image,
            imageDescription = getItems(context)[position].imageDescription,
            title = getItems(context)[position].title,
            artist = getItems(context)[position].artist,
            year = getItems(context)[position].year,
            onPreviousButtonClicked = {
                position = if (position == 0) getItems(context).size - 1 else position - 1
            },
            onNextButtonClicked = { position = (position + 1) % getItems(context).size }
        )
    }
}

@Composable
fun ItemArt(
    modifier: Modifier = Modifier,
    image: Int,
    imageDescription: String,
    title: String,
    artist: String,
    year: String,
    onPreviousButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = imageDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(1f, true)
                .align(Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp, top = 32.dp)
                .clip(shape = RoundedCornerShape(25.dp))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp)
                .background(color = Color(0xffEDEDED)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$artist ($year)",
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 0.dp, end = 24.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = onPreviousButtonClicked
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = onNextButtonClicked
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpaceApp() {
    ArtSpaceTheme {
        MainContainer()
    }
}

data class Item(
    @DrawableRes val image: Int,
    val imageDescription: String,
    val title: String,
    val artist: String,
    val year: String,
)

fun getItems(context: Context): List<Item> = listOf(
    Item(
        R.drawable.image_monalisa,
        context.resources.getString(R.string.the_mona_lisa),
        context.resources.getString(R.string.the_mona_lisa),
        context.resources.getString(R.string.the_mona_lisa_artist),
        context.resources.getString(R.string.the_mona_lisa_year),
    ),
    Item(
        R.drawable.image_girl_with_a_pearl_earring,
        context.resources.getString(R.string.girl_with_a_pearl_earring),
        context.resources.getString(R.string.girl_with_a_pearl_earring),
        context.resources.getString(R.string.girl_with_a_pearl_earring_artist),
        context.resources.getString(R.string.girl_with_a_pearl_earring_year),
    ),
    Item(
        R.drawable.image_the_starry_night,
        context.resources.getString(R.string.the_starry_night),
        context.resources.getString(R.string.the_starry_night),
        context.resources.getString(R.string.the_starry_night_artist),
        context.resources.getString(R.string.the_starry_night_year),
    ),
    Item(
        R.drawable.image_the_kiss,
        context.resources.getString(R.string.the_kiss),
        context.resources.getString(R.string.the_kiss),
        context.resources.getString(R.string.the_kiss_artist),
        context.resources.getString(R.string.the_kiss_year),
    ),
    Item(
        R.drawable.image_arrangement_in_grey_and_black_no_1,
        context.resources.getString(R.string.arrangement_in_grey_and_black_no_1),
        context.resources.getString(R.string.arrangement_in_grey_and_black_no_1),
        context.resources.getString(R.string.arrangement_in_grey_and_black_no_1_artist),
        context.resources.getString(R.string.arrangement_in_grey_and_black_no_1_year),
    )
)

























































