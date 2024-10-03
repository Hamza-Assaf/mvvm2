package com.example.mvvm2.features.articles.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.mvvm2.databinding.FragmentArticleListBinding
import com.example.mvvm2.features.ArticleViewModel
import com.example.mvvm2.features.articles.adapters.ArticleAdapter
import com.example.mvvm2.features.articles.ui.ArticleListFragmentDirections.Companion.actionListToLogin
import com.example.mvvm2.features.database.DataBaseHelper
import com.example.mvvm2.features.model.topNews.TopNewsModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import com.example.mvvm2.features.articles.ui.ArticleListFragmentDirections.Companion.actionArticleListToArticleDetails

@AndroidEntryPoint
class ArticleListFragment : Fragment() {


    private lateinit var binding: FragmentArticleListBinding
    private val adapter = ArticleAdapter()
    private val viewModel : ArticleViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = FragmentArticleListBinding.inflate(layoutInflater)
        binding.movieRv.adapter = adapter
        binding.movieRv.layoutManager = LinearLayoutManager(requireContext())


viewModel.getTopHeadLines()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.response.collect {
                adapter.setArticles(it.articles as List<TopNewsModel>)
            }
        }

//binding.root.setOnClickListener{
//
//    val action = actionArticleListToArticleDetails()
//    findNavController().navigate(action)
//
//}



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



        return binding.root

    }
}










