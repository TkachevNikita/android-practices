package com.example.moviesapp.business.moviesList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.domain.model.MovieItemList


@Composable
fun MoviesScreen(onNavigate: (String) -> Unit) {
    val viewModel: MoviesListViewModel = viewModel()
    val uiState = viewModel.uiState

    val listState = rememberLazyStaggeredGridState()

    if (uiState.value.isLoading)
        Box(
            modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    if (uiState.value.data != null)
        ShowMovieList(uiState.value.data!!, listState, onNavigate)

}

@Composable
private fun ShowMovieList(
    data: List<MovieItemList>,
    listState: LazyStaggeredGridState,
    onNavigate: (String) -> Unit
) {
    LazyVerticalStaggeredGrid(
        modifier = Modifier.padding(vertical = 3.dp, horizontal = 3.dp),
        columns = StaggeredGridCells.Adaptive(150.dp),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        state = listState
    ) {
        items(data) {
            MovieItem(it, onNavigate)
        }
    }
}
