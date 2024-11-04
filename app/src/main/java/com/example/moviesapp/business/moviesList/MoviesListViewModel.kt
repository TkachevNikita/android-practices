package com.example.moviesapp.business.moviesList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.RepositoryImpl
import com.example.domain.model.MovieItemList
import com.example.domain.model.Resources
import com.example.domain.useCases.GetMoviesListUseCase
import com.example.moviesapp.UiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MoviesListViewModel: ViewModel() {
    private val repository = RepositoryImpl()
    private val getMoviesListUseCase = GetMoviesListUseCase(repository)
    private val _uiState: MutableState<UiState<List<MovieItemList>>> = mutableStateOf(UiState())
    val uiState: State<UiState<List<MovieItemList>>> = _uiState

    private val movieItemListState = MutableSharedFlow<Resources<List<MovieItemList>>>()

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
        movieItemListState.emit(getMoviesListUseCase())
    }
}