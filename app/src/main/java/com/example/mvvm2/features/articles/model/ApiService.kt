package com.example.mvvm2.features.articles.model

import com.example.mvvm2.features.utils.Constants
import com.example.mvvm2.features.articles.model.allNews.AllNewsResponseModel
import com.example.mvvm2.features.articles.model.topNews.TopNewsResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.topHeadlinesUrl)
    suspend fun getTopHeadlines(@Query("sources") sources: String?, @Query("apiKey") apiKey: String?): TopNewsResponseModel

    @GET(Constants.everythingUrl)
    suspend fun getEverything(@Query("q") q: String?, @Query("searchIn") searchIn : String?,@Query("sources") sources: String?,@Query("domains") domains: String? , @Query("apiKey") apiKey: String?): AllNewsResponseModel

}
