package com.example.mvvm2.features.forgotPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mvvm2.databinding.FragmentPassChangedBinding
import com.example.mvvm2.features.forgotPassword.PasswordChangeSuccessFragmentDirections.Companion.changedToLogin


class PasswordChangeSuccessFragment : Fragment() {

   private lateinit var binding : FragmentPassChangedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPassChangedBinding.inflate(inflater, container, false)

        binding.backToLogin.setOnClickListener {
            val action = changedToLogin()
            findNavController().navigate(action)


        }




        return binding.root
    }


}