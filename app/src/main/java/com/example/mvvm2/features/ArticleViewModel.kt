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

//   private val  apiService = ApiService.getInstance()
    var articleList = MutableLiveData<List<ArticleModel>>()
    val errorMessage = MutableLiveData<String>()
//     private val myRepo = ArticleRepository(apiService)

    private val call: Call<ResponseModel> = repository.getLatestNews()

    fun getTopHeadLines() {

        //repo is not being used


        call.enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {

                if (response.isSuccessful) {
                    articleList.postValue( response.body()?.articles)


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








