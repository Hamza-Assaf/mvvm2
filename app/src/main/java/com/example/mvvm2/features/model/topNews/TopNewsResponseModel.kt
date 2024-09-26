package com.example.mvvm2.features.model.topNews

import com.google.gson.annotations.SerializedName

data class TopNewsResponseModel(

    @SerializedName("status")
    private var status: String? = "",

    @SerializedName("totalResults")
    private var totalResults: Int?=0,

    @SerializedName("articles")
    var articles: List<TopNewsModel>?= listOf()

)
