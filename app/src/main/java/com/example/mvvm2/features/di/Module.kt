package com.example.mvvm2.features.di

import com.example.mvvm2.features.utils.Constants.Companion.baseUrl
import com.example.mvvm2.features.data.remote.ApiService
import com.example.mvvm2.features.domain.repository.RepoImpl
import com.example.mvvm2.features.domain.repository.Repository
import com.example.mvvm2.features.model.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun provideApi(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
    }
}


    @Module
    @InstallIn(SingletonComponent::class)
    class ProvideRetrofit() {

        @Provides
        @Singleton
        fun provideApiService(retrofit: Retrofit): ApiService =
            retrofit.create(ApiService::class.java)

    }

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class BindRepo() {

        @Binds
        abstract fun bindRepo(repoImpl: RepoImpl): Repository
    }
