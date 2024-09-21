package com.example.mvvm2.features.articles.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.mvvm2.databinding.ActivityMainBinding
import com.example.mvvm2.features.database.DataBaseHelper
import com.example.mvvm2.databinding.FragmentArticleListBinding
import com.example.mvvm2.features.ArticleViewModel
import com.example.mvvm2.features.ViewModelFactory
import com.example.mvvm2.features.articles.adapters.ArticleAdapter
import com.example.mvvm2.features.articles.ui.ArticleListFragmentDirections.Companion.actionListToLogin
import com.example.mvvm2.features.repository.ArticleRepository
import com.example.mvvm2.features.retrofit.ApiService


class ArticleListFragment : Fragment() {

    private val apiService = ApiService.getInstance()
    private lateinit var binding: FragmentArticleListBinding

    //    private var viewModel = ViewModelProvider(this, ViewModelFactory(ArticleRepository(apiService))).get(ArticleViewModel::class.java)
    private val TAG = "ArticleListFragment"
    private val adapter = ArticleAdapter()
    private val viewModel: ArticleViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {


        viewModel = ViewModelProvider(this, ViewModelFactory(ArticleRepository(apiService))).get(ArticleViewModel::class.java)

        binding = FragmentArticleListBinding.inflate(layoutInflater)
//        viewModel = ViewModelProvider(this,ViewModelFactory(ArticleRepository(apiService))).get(ArticleViewModel::class.java)
        binding.movieRv.adapter = adapter


        val db = Room.databaseBuilder(binding.root.context, DataBaseHelper::class.java, "users")
            .allowMainThreadQueries().build()
        val userDao = db.userDao()
        val email = arguments?.getString("Email")

        if (email != null) binding.welcomeText.text =
            "Welcome " + userDao.findUserByEmail(email).userName
        binding.backButton.backButton.setOnClickListener {

            val action = actionListToLogin()
            findNavController().navigate(action)

        }

        viewModel.articleList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setArticleList(it)
        })
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {

        })

        viewModel.getTopHeadLines()

        return binding.root
    }

}











