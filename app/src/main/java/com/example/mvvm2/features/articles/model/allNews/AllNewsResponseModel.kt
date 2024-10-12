package com.example.mvvm2.features.articles.model.allNews

import com.example.mvvm2.features.articles.model.topNews.TopNewsModel
import com.google.gson.annotations.SerializedName

data class AllNewsResponseModel(


    @SerializedName("status")
    private var status: String? = "",

    @SerializedName("totalResults")
    private var totalResults: Int?=0,

    @SerializedName("articles")
    var articles: List<TopNewsModel>?= listOf()


)