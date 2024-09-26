package com.example.mvvm2.features.model.allNews

import com.example.mvvm2.features.model.topNews.TopNewsModel
import com.google.gson.annotations.SerializedName

data class AllNewsResponseModel(

    @SerializedName("Status")
    private val status: String,

    @SerializedName("totalResults")
    private val totalResults: String,

    @SerializedName("articles")
    private val articles: List<TopNewsModel>


)