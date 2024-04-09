package com.example.shortnews.presentation.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shortnews.presentation.components.Loader
import com.example.shortnews.presentation.viewmodel.NewsViewModel
import com.example.utils.ResourceState

@Composable
fun HomeScreen(
    viewModel: NewsViewModel = hiltViewModel()
) {
    val newsResponse by viewModel.news.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when (newsResponse) {
            is ResourceState.Loading<*> -> {
                Loader()
            }
            is ResourceState.Success<*> -> {
                val response = (newsResponse as ResourceState.Success).data
            }
            is ResourceState.Error<*> -> {
                val error = (newsResponse as ResourceState.Error)

            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
//    HomeScreen(NewsViewModel())
}