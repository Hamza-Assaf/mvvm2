package com.example.mvvm2.features.forgotPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mvvm2.databinding.FragmentOtpBinding
import com.example.mvvm2.features.forgotPassword.OtpFragmentDirections.Companion.actionOtp2ToForgotPassword
import com.example.mvvm2.features.forgotPassword.OtpFragmentDirections.Companion.actionOtp2ToNewPass


class OtpFragment : Fragment() {

    private lateinit var binding: FragmentOtpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentOtpBinding.inflate(layoutInflater)
        val view = binding.root

        binding.verifyButton.setOnClickListener{

            val email = arguments?.getString("Email")
            val action = actionOtp2ToNewPass(email.toString())
            findNavController().navigate(action)

        }
        binding.backButton.backButton.setOnClickListener{

            val action = actionOtp2ToForgotPassword()
            findNavController().navigate(action)

        }


        return view
    }


    }
