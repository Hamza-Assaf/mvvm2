package com.example.mvvm2.features.forgotPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.mvvm2.features.database.DataBaseHelper
import com.example.mvvm2.databinding.FragmentForgotPassBinding
import com.example.mvvm2.features.forgotPassword.ForgotPasswordFragmentDirections.Companion.actionForgotPasswordToLogin
import com.example.mvvm2.features.forgotPassword.ForgotPasswordFragmentDirections.Companion.actionForgotPasswordToOtp2



class ForgotPasswordFragment : Fragment() {

        private lateinit var binding: FragmentForgotPassBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentForgotPassBinding.inflate(layoutInflater)
        val view = binding.root

        val db = Room.databaseBuilder(binding.root.context, DataBaseHelper::class.java, "users").allowMainThreadQueries().build()

        val userDao = db.userDao()


        binding.backButton.backButton.setOnClickListener{

            val action = actionForgotPasswordToLogin()
            findNavController().navigate(action)

        }

        binding.forgotButton.setOnClickListener {


            if (userDao.checkEmailExists(binding.email.text.toString())) {

                val email = binding.email.text.toString()

                Toast.makeText(
                    binding.root.context,
                    "Please Enter the OTP sent to $email",
                    Toast.LENGTH_LONG
                ).show()

                val action = actionForgotPasswordToOtp2(binding.email.text.toString())
                findNavController().navigate(action)


            } else {

                Toast.makeText(binding.root.context, "Email does not exist", Toast.LENGTH_SHORT)
                    .show()


            }

        }

        return view
    }


}