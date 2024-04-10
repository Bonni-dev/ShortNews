package com.example.shortnews.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.shortnews.data.entity.Article
import com.example.shortnews.presentation.components.NewsItemPage
import com.example.shortnews.presentation.views.HomeScreen
import com.example.shortnews.shared.mockArticle

@Composable
fun AppNavigationGraph() {
    val navController = rememberNavController()
    var selectedArticle: Article by remember { mutableStateOf(mockArticle()) }

    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {

        composable(Routes.HOME_SCREEN) {
            HomeScreen(onArticleSelected = { article ->
                selectedArticle = article
                navController.navigate("${Routes.NEWS_ITEM}/${article.source.id}")
            })
        }

        composable(
            route = "${Routes.NEWS_ITEM}/{${Routes.ARTICLE}}",
            arguments = listOf(
                navArgument(name = Routes.ARTICLE) {
                    type = NavType.StringType
                }
            )
        ) {
            val articleId = it.arguments?.getString(Routes.ARTICLE) ?: ""
            val article: Article = selectedArticle.takeIf { it.source.id == articleId }!!
            NewsItemPage(article = article)
        }
    }
}