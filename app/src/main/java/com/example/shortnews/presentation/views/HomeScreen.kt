package com.example.shortnews.presentation.views

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shortnews.data.entity.Article
import com.example.shortnews.presentation.components.Loader
import com.example.shortnews.presentation.components.NewsRowComponent
import com.example.shortnews.presentation.viewmodel.NewsViewModel
import com.example.utils.ResourceState

@Composable
fun HomeScreen(
    viewModel: NewsViewModel = hiltViewModel(),
    onArticleSelected: (Article) -> Unit
) {
    val newsResponse by viewModel.news.collectAsState()
    val pagerState = rememberLazyListState(
        initialFirstVisibleItemIndex = 0,
        initialFirstVisibleItemScrollOffset = 0
    )

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when (newsResponse) {
            is ResourceState.Loading<*> -> {
                Loader()
                Log.d("HOME_SCREEN", "INTO LOADING")
            }

            is ResourceState.Success<*> -> {
                val response = (newsResponse as ResourceState.Success).data
                Log.d("HOME_SCREEN", "INTO SUCCESS")
                if (response.articles.isNotEmpty()) {
                    LazyColumn(state = pagerState) {
                        items(response.totalResults) { index ->
                            val articles = response.articles[index]
                            NewsRowComponent(articles, onArticleSelected)
                        }
                    }
                }
            }

            is ResourceState.Error<*> -> {
                val error = (newsResponse as ResourceState.Error)
                Log.d("HOME_SCREEN", "INTO ERROR: $error")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(onArticleSelected = { article ->

    })
}