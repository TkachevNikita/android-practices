package com.example.moviesapp.business.movie

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.RepositoryImpl
import com.example.domain.model.Movie
import com.example.domain.model.Resources
import com.example.domain.useCases.GetMovieUseCase
import com.example.moviesapp.UiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MovieViewModel(id: String): ViewModel() {
    private val repository = RepositoryImpl()
    private val getMovieUseCase = GetMovieUseCase(id, repository)
    private val _uiState: MutableState<UiState<Movie>> = mutableStateOf(UiState())
    val uiState: State<UiState<Movie>> = _uiState

    private val movieItemListState = MutableSharedFlow<Resources<Movie>>()


    init {
        viewModelScope.launch {
            getMovie()
        }

        viewModelScope.launch {
            movieItemListState.collect {
                when (it) {
                    is Resources.Error -> _uiState.value =
                        UiState(error = UiState.Error.RequestError(it.message))

                    is Resources.Success ->
                        _uiState.value = UiState(data = it.data)
                }
            }
        }
    }


    private suspend fun getMovie() {
        _uiState.value = UiState(isLoading = true)
        movieItemListState.emit(getMovieUseCase())
    }
}