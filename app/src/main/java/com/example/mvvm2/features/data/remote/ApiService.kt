package com.example.mvvm2.features.data.remote

import com.example.mvvm2.features.utils.Constants
import com.example.mvvm2.features.model.allNews.AllNewsResponseModel
import com.example.mvvm2.features.model.topNews.TopNewsResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.topHeadlinesUrl)
    suspend fun getTopHeadlines(@Query("sources") sources: String?, @Query("apiKey") apiKey: String?): TopNewsResponseModel

    @GET(Constants.everythingUrl)
    suspend fun getEverything(@Query("bitcoin") subject: String?, @Query("apiKey") apiKey: String?): AllNewsResponseModel

}
