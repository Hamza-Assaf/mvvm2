package com.example.mvvm2.features.articles.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.mvvm2.databinding.FragmentArticleListBinding
import com.example.mvvm2.features.ArticleViewModel
import com.example.mvvm2.features.articles.adapters.ArticleAdapter
import com.example.mvvm2.features.articles.ui.ArticleListFragmentDirections.Companion.actionListToLogin
import com.example.mvvm2.features.database.DataBaseHelper
import com.example.mvvm2.features.model.topNews.TopNewsResponseModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ArticleListFragment : Fragment() {

    private lateinit var binding: FragmentArticleListBinding
    private val adapter = ArticleAdapter()
    private val viewModel = ViewModelProvider(this)[ArticleViewModel::class.java]



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {


        binding = FragmentArticleListBinding.inflate(layoutInflater)
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

    viewModel.getTopHeadLines()


        return binding.root

    }
}










