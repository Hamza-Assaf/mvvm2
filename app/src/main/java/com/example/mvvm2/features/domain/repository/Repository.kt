package com.example.mvvm2.features.domain.repository

import android.app.Application
import com.example.mvvm2.features.data.remote.ApiService
import com.example.mvvm2.features.di.Module
import com.example.mvvm2.features.model.RemoteDataSource
import com.example.mvvm2.features.model.allNews.AllNewsResponseModel
import com.example.mvvm2.features.model.topNews.TopNewsResponseModel
import com.example.mvvm2.features.utils.Constants.Companion.apiKey
import retrofit2.Call
import javax.inject.Inject

interface Repository {


    suspend fun getTopHeadLines() : TopNewsResponseModel


    suspend fun getEverything() : AllNewsResponseModel


}

class RepoImpl @Inject constructor(private val dataSource : RemoteDataSource): Repository {



    override suspend fun getTopHeadLines():TopNewsResponseModel = dataSource.getTopHeadlines()

    override suspend fun getEverything(): AllNewsResponseModel = dataSource.getEverything()









}