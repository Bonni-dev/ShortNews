package com.example.shortnews.shared

import com.example.shortnews.data.entity.Article
import com.example.shortnews.data.entity.Source

fun mockArticle(): Article {
    return Article(
        source = Source("lorem ipsum", "lorem"),
        author = "lorem ipsum lorem ipsum lorem ipsum",
        title = "lorem ipsum ",
        description = "lorem ipsum lorem ipsum lorem ipsum",
        url = "lorem ipsum lorem ipsum lorem ipsum",
        urlToImage = "lorem ipsum lorem ipsum lorem ipsum",
        publishAt = "lorem ipsum lorem ipsum lorem ipsum",
        content = "lorem ipsum lorem ipsum lorem ipsum",
    )
}