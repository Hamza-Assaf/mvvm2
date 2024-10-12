package com.example.mvvm2.features.articles.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm2.features.articles.model.allNews.AllNewsResponseModel
import com.example.mvvm2.features.domain.repository.Repository
import com.example.mvvm2.features.articles.model.topNews.TopNewsResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ArticleViewModel @Inject constructor(private val repository: Repository ): ViewModel() {


    private val _topNewsresponse = MutableStateFlow(TopNewsResponseModel())
    var topNewsresponse = _topNewsresponse.asStateFlow()
    private val _allNewsresponse = MutableStateFlow(AllNewsResponseModel())
    var allNewsresponse = _allNewsresponse.asStateFlow()


    fun getTopHeadLines() {

        viewModelScope.launch(){
            _topNewsresponse.emit(repository.getTopHeadLines())
            }
        }

    fun getEverything() {
        viewModelScope.launch() {
            _allNewsresponse.emit(repository.getEverything())
        }
    }

        fun fetchTopArticles() = viewModelScope.launch {
            val response = repository.getTopHeadLines()
            _topNewsresponse.value = response

        }
    fun fetchAllArticles() = viewModelScope.launch {
        val response = repository.getEverything()
        _allNewsresponse.value = response

    }

    }


//        viewModelScope.launch()
//        {
//
//            repository.getTopHeadLines()
//        response.collect(){
//            _response.value = it
//        }
//
//
//            }
//
//        }





