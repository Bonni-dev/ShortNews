package com.example.shortnews.presentation.views

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shortnews.presentation.viewmodel.NewsViewModel

@Composable
fun HomeScreen(
    viewModel: NewsViewModel = hiltViewModel()
){
    Surface {

    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(NewsViewModel())
}