package com.example.shortnews.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.shortnews.R
import com.example.shortnews.data.entity.Article
import com.example.shortnews.data.entity.Source
import com.example.shortnews.shared.mockArticle

@Composable
fun NewsRowComponent(page: Int, article: Article) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White)
            .wrapContentHeight()
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            model = article.urlToImage,
            contentDescription = article.description,
            contentScale = ContentScale.FillWidth,
            placeholder = painterResource(id = R.drawable.ic_placeholder),
            error = painterResource(id = R.drawable.ic_placeholder),
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            text = article.title,
            style = TextStyle(
                fontSize = 20.sp
            ),
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = article.description,
            maxLines = 3
        )
    }
}


@Preview
@Composable
fun NewsRowComponentPreview() {
    NewsRowComponent(page = 0, article = mockArticle())
}
