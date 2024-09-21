package com.example.mvvm2.features.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.mvvm2.features.database.DataBaseHelper
import com.example.mvvm2.databinding.FragmentLoginBinding
import com.example.mvvm2.features.login.LoginFragmentDirections.Companion.actionLoginToForgotPassword
import com.example.mvvm2.features.login.LoginFragmentDirections.Companion.actionLoginToRegister
import com.example.mvvm2.features.login.LoginFragmentDirections.Companion.actionLoginToWelcomeScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.mvvm2.features.login.LoginFragmentDirections.Companion.actionLoginToArticleList




class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
     private var validEmail: Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentLoginBinding.inflate(layoutInflater)
        val view = binding.root

        val db = Room.databaseBuilder(binding.root.context, DataBaseHelper::class.java, "users").build()

        val userDao = db.userDao()
        binding.forgotPass.setOnClickListener{

            val action = actionLoginToForgotPassword()
            findNavController().navigate(action)


        }

            binding.loginButton.setOnClickListener{

                CoroutineScope(Dispatchers.IO).launch {
                    validEmail = userDao.checkCredentials(
                        binding.email.text.toString(),
                        binding.password.text.toString()
                    )
                }
                if (validEmail)
                 {

                    Toast.makeText(binding.root.context, "Login Successful", Toast.LENGTH_SHORT)
                        .show()

                    val action = actionLoginToArticleList(binding.email.text.toString())
                    findNavController().navigate(action)

                } else if (binding.email.text.toString()
                        .isEmpty() || binding.password.text.toString().isEmpty()
                ) {

                    Toast.makeText(
                        binding.root.context,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    Toast.makeText(
                        binding.root.context,
                        "Wrong Email or Password",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }









        binding.backButton.backButton.setOnClickListener{

         val action = actionLoginToWelcomeScreen()
         findNavController().navigate(action)

        }
        binding.registerNow.setOnClickListener{
            val action = actionLoginToRegister()
            findNavController().navigate(action)
        }


return view
    }

}
