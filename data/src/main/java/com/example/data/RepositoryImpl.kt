package com.example.data

import com.example.data.remote.MovieAPI
import com.example.data.remote.RetrofitModule
import com.example.data.remote.model.toMovie
import com.example.data.remote.model.toMovieItem
import com.example.domain.RepositoryMovies
import com.example.domain.model.Movie
import com.example.domain.model.MovieItemList
import com.example.domain.model.Resources


class RepositoryImpl() : RepositoryMovies {
    val api: MovieAPI = RetrofitModule.getRetrofit

    override suspend fun getMoviesList(): Resources<List<MovieItemList>> {
        val response = api.getMovies()

        if (!response.isSuccessful)
            return Resources.Error(message = response.body().toString())

        val movies = response.body()!!.docs.map { it.toMovieItem() }
        return Resources.Success(data = movies)
    }

    override suspend fun getMovie(id: String): Resources<Movie> {
        val response = api.getMovie(id.toInt())

        if (!response.isSuccessful)
            return Resources.Error(message = response.body().toString())

        val movie = response.body()!!.docs.first().toMovie()
        return Resources.Success(data = movie)
    }
}
