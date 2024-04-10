package com.example.shortnews.presentation.views

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shortnews.presentation.components.Loader
import com.example.shortnews.presentation.components.NewsRowComponent
import com.example.shortnews.presentation.viewmodel.NewsViewModel
import com.example.utils.ResourceState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: NewsViewModel = hiltViewModel()
) {
    val newsResponse by viewModel.news.collectAsState()
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        100
    }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        VerticalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            pageSize = PageSize.Fill,
            pageSpacing = 8.dp
        ) { page ->
            when (newsResponse) {
                is ResourceState.Loading<*> -> {
                    Loader()
                    Log.d("HOME_SCREEN","INTO LOADING")

                }

                is ResourceState.Success<*> -> {
                    val response = (newsResponse as ResourceState.Success).data
                    Log.d("HOME_SCREEN","INTO SUCCESS")
                    if (response.articlesList.isNotEmpty()) {
                        NewsRowComponent(page, response.articlesList[page])
                    }
                }

                is ResourceState.Error<*> -> {
                    val error = (newsResponse as ResourceState.Error)
                    Log.d("HOME_SCREEN","INTO ERROR: $error")
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
//    HomeScreen(NewsViewModel())
}