package com.example.mvvm2.features

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvm2.R
import com.example.mvvm2.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

lateinit var binding : FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
binding = FragmentSettingsBinding.inflate(layoutInflater)




        return binding.root
    }

    }
