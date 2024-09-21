package com.example.mvvm2.features

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm2.features.model.ArticleModel
import com.example.mvvm2.features.model.ResponseModel
import com.example.mvvm2.features.repository.ArticleRepository
import com.example.mvvm2.features.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleViewModel(private val repository: ArticleRepository) : ViewModel() {

   val  apiService = ApiService.getInstance()
    val apiKey = "f391df4c366b4be0b0a7e303c92bd5c4"
    var articleList = MutableLiveData<List<ArticleModel>>()
    val errorMessage = MutableLiveData<String>()
    val call: Call<ResponseModel> = apiService.getLatestNews("techcrunch", apiKey)


    fun getTopHeadLines() {

        call.enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {

                if (response.isSuccessful) {
                    articleList.postValue(response.body()?.articles)


                } else {
                    errorMessage.postValue("Error")
                }

            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}


//        val response = repository.getLatestNews()
//        response.enqueue( object : Callback<ResponseModel> {
//
//
//            override fun onResponse(
//                call: Call<ResponseModel>,
//                response: Response<ResponseModel>
//            ) {
//                if (response.isSuccessful) {
//                    articleList.postValue(response.body()?.articles)
//                } else {
//                    errorMessage.postValue("Error")
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
//                errorMessage.postValue(t.message)
//            }
//        })








