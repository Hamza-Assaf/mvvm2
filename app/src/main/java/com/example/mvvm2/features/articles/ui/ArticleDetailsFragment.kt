package com.example.mvvm2.features.articles.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.mvvm2.databinding.FragmentArticleDetailsBinding
import com.example.mvvm2.features.articles.ui.ArticleDetailsFragmentDirections
import com.example.mvvm2.features.articles.ui.ArticleDetailsFragmentDirections.Companion.actionArticleDetailsToArticleList







class ArticleDetailsFragment : Fragment() {

    lateinit var binding: FragmentArticleDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentArticleDetailsBinding.inflate(layoutInflater)




        binding.articleTitle.text = arguments?.getString("article")
        binding.articleDescription.text = arguments?.getString("description")
        Glide.with(binding.articleImage.context).asBitmap().load(arguments?.getString("image"))
            .into(binding.articleImage)
         val url = arguments?.getString("url")


        binding.backButton.backButton.setOnClickListener {
            val action = actionArticleDetailsToArticleList()
            findNavController().navigate(action)
        }


        binding.articleImage.setOnClickListener {

            val toItem = ArticleDetailsFragmentDirections.actionArticleDetailsToWebActivity( url.toString())

            findNavController().navigate(toItem)
        }



        return binding.root
    }




}