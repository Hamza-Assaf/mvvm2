package com.example.mvvm2.features.articles.model.topNews

import com.google.gson.annotations.SerializedName

data class TopNewsSourceModel (




    @SerializedName ("id")
    private  var id : String,

    @SerializedName("name")
    private  var name : String


)