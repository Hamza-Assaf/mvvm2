package com.example.mvvm2.features.articles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.annotation.SuppressLint
import com.example.mvvm2.databinding.FragmentWebActivityBinding


class WebActivityFragment : Fragment() {


    private lateinit var binding : FragmentWebActivityBinding


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentWebActivityBinding.inflate(layoutInflater)






            binding.webView.loadUrl( arguments?.getString("url").toString())
            val webSettings: WebSettings = binding.webView.getSettings()
            binding.webView.settings.javaScriptEnabled = true





        return binding.root
    }
}
