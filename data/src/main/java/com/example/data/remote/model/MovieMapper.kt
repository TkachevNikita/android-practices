package com.example.data.remote.model

import com.example.domain.model.Movie
import com.example.domain.model.MovieItemList

fun Doc.toMovieItem(): MovieItemList {
    return MovieItemList(id, name, year, poster.url)
}

fun Doc.toMovie(): Movie {
    return Movie(name, description, year.toString(), poster.url)
}