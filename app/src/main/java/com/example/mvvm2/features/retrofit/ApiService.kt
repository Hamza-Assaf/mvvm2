package com.example.mvvm2.features.retrofit

import com.example.mvvm2.features.model.ArticleModel
import com.example.mvvm2.features.model.ResponseModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("top-headlines")
    fun getLatestNews(@Query("sources") source: String?, @Query("apiKey") apiKey: String?): Call<ResponseModel>

   companion object {

       private var retrofitService: ApiService? = null

       fun getInstance(): ApiService{

           if(retrofitService == null){
               val retrofit = Retrofit.Builder().baseUrl("https://newsapi.org/v2/").addConverterFactory(GsonConverterFactory.create()).build()
               retrofitService = retrofit.create(ApiService::class.java)
           }
           return retrofitService!!
           }


       }

   }

    








