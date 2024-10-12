package com.example.mvvm2.features.articles.model

import com.example.mvvm2.features.utils.Constants.Companion.apiKey
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService){

    suspend fun getTopHeadlines() = apiService.getTopHeadlines("techcrunch", apiKey)
    suspend fun getEverything() = apiService.getEverything("bitcoin","title","techcrunch","bbc.co.uk", apiKey)

}