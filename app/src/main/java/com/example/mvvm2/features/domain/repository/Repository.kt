package com.example.mvvm2.features.domain.repository

import com.example.mvvm2.features.articles.model.RemoteDataSource
import com.example.mvvm2.features.articles.model.allNews.AllNewsResponseModel
import com.example.mvvm2.features.articles.model.topNews.TopNewsResponseModel
import javax.inject.Inject

interface Repository {


    suspend fun getTopHeadLines() : TopNewsResponseModel


    suspend fun getEverything() : AllNewsResponseModel


}

class RepoImpl @Inject constructor(private val dataSource : RemoteDataSource): Repository {



    override suspend fun getTopHeadLines(): TopNewsResponseModel = dataSource.getTopHeadlines()

    override suspend fun getEverything(): AllNewsResponseModel = dataSource.getEverything()









}