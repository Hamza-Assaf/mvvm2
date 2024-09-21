package com.example.mvvm2.features.model

import com.google.gson.annotations.SerializedName

data class ResponseModel(

    @SerializedName("status")
    private val status: String,

    @SerializedName("totalResults")
    private val totalResults: Int,

    @SerializedName("articles")
    val articles: List<ArticleModel>

)
