package com.example.moviesapp.business.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.domain.model.Movie

@Composable
fun MovieScreen(id: String) {
    val factory = remember { MyViewModelFactory(id) }
    val viewModel: MovieViewModel = viewModel(factory = factory)
    val uiState = viewModel.uiState


    if (uiState.value.isLoading)
        CircularProgressIndicator()

    if (uiState.value.data != null)
        ShowMovie(uiState.value.data!!)
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ShowMovie(data: Movie) {

    Column(modifier = Modifier.padding(all = 5.dp)) {


        Row {
            GlideImage(
                modifier = Modifier
                    .clip(RectangleShape)
                    .width(200.dp)
                    .height(300.dp),
//                    .padding(start=5.dp, top=5.dp),
                model = data.poster,
                contentScale = ContentScale.Crop,
                contentDescription = "Product Image",
            )

            Column(modifier = Modifier.padding(start = 3.dp)) {
                Text(text = data.name)
                Text(text = data.year)
            }
        }
        Text(modifier = Modifier.padding(top = 3.dp), text = data.description)
    }
}
