package com.example.domain.useCases

import com.example.domain.RepositoryMovies

class GetMoviesListUseCase(private val repositoryMovies: RepositoryMovies) {
    suspend operator fun invoke() = repositoryMovies.getMoviesList()
}