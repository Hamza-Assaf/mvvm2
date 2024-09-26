package com.example.mvvm2.features.model.topNews

import com.google.gson.annotations.SerializedName

data class TopNewsModel(


    @SerializedName("source")
    var source: TopNewsSourceModel,

    @SerializedName("author")
    var author: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("url")
    var url: String,

    @SerializedName("urlToImage")
    var urlToImage: String,

    @SerializedName("publishedAt")
    var publishedAt: String,

    @SerializedName("content")
    var content: String


)
