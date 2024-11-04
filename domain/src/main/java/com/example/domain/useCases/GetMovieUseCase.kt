package com.example.domain.useCases

import com.example.domain.RepositoryMovies

class GetMovieUseCase(private val id: String, private val repositoryMovies: RepositoryMovies) {
    suspend operator fun invoke() = repositoryMovies.getMovie(id)
}