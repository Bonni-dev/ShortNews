package com.example.shortnews.data.api

import com.example.shortnews.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

   @GET("v2/top-headlines")
    fun getNews(
        @Query("country") country: String = "br",
        @Query("apiKey") apiKey: String = "4e3a3e771fc141ac8c382facd27ecf52"
    ) : Response<NewsResponse>
}

//https://newsapi.org/v2/top-headlines?country=br&apiKey=4e3a3e771fc141ac8c382facd27ecf52