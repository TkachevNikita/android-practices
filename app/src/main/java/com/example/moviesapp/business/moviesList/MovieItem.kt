package com.example.moviesapp.business.moviesList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.domain.model.MovieItemList
import com.example.moviesapp.business.navigation.Routes

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieItem(movieItemList: MovieItemList, onNavigate: (String) -> Unit) {

    Card(
        modifier = Modifier.clickable {
            onNavigate(Routes.MOVIE.replace("{id}", movieItemList.id.toString()))
        },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Box() {

            GlideImage(
                modifier = Modifier.clip(RectangleShape),
                model = movieItemList.logo,
                contentScale = ContentScale.Crop,
                contentDescription = "Product Image",
            )

            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 9.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(
                        Color(102, 102, 102, 200)
                    ),
            ) {
                val title = if (movieItemList.name.length > 10)
                    movieItemList.name.substring(0, 10) + "..."
                else
                    movieItemList.name
                Text(
                    modifier = Modifier.padding(horizontal = 9.dp),
                    text = title,
                    color = Color.White,
                    fontSize = 15.sp
                )
            }
        }
    }
}