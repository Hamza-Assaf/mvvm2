package com.example.mvvm2.features.model

import com.example.mvvm2.features.utils.Constants.Companion.apiKey
import com.example.mvvm2.features.data.remote.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService){

    suspend fun getTopHeadlines() = apiService.getTopHeadlines("techcrunch", apiKey)
    suspend fun getEverything() = apiService.getEverything("bitcoin", apiKey)

}