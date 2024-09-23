package com.example.mvvm2.features.repository

import com.example.mvvm2.features.retrofit.ApiService

class ArticleRepository(private val apiService: ApiService) {

    private val apiKey = "f391df4c366b4be0b0a7e303c92bd5c4"
    fun getLatestNews() = apiService.getLatestNews("techcrunch", apiKey)



}