package com.example.retrofitdemo

import NewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface apiInterface

{
    @GET("v2/top-headlines")
    suspend fun getPhoto():Response<NewsResponse>
}


