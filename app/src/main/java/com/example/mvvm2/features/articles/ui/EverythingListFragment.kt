package com.example.mvvm2.features.articles.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm2.databinding.FragmentEverythingListBinding
import com.example.mvvm2.features.articles.adapters.ArticleAdapter
import com.example.mvvm2.features.articles.model.topNews.TopNewsModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EverythingListFragment : Fragment() {


    lateinit var binding: FragmentEverythingListBinding
    private val adapter = ArticleAdapter()
    private val viewModel : ArticleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
binding = FragmentEverythingListBinding.inflate(layoutInflater)
        binding.movieRv.adapter = adapter
        binding.movieRv.layoutManager = LinearLayoutManager(requireContext())

       viewModel.getEverything()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.allNewsresponse.collect {
                adapter.setArticles(it.articles as List<TopNewsModel>)
            }
        }

        return binding.root
    }


    }
