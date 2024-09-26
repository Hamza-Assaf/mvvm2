package com.example.mvvm2.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm2.features.domain.repository.Repository
import com.example.mvvm2.features.model.topNews.TopNewsResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ArticleViewModel @Inject constructor(private val repository: Repository, ): ViewModel() {


    private val _response = MutableStateFlow<TopNewsResponseModel>(TopNewsResponseModel())
    private val response = _response.asStateFlow()


    fun getTopHeadLines() {

        viewModelScope.launch()
        {
            repository.getTopHeadLines()
        response.collect(){
            _response.value = it
        }


            }

        }

    }



