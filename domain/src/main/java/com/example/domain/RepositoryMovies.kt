package com.example.domain

import com.example.domain.model.Movie
import com.example.domain.model.MovieItemList
import com.example.domain.model.Resources

interface RepositoryMovies {
    suspend fun getMoviesList(): Resources<List<MovieItemList>>
    suspend fun getMovie(id: String): Resources<Movie>
}