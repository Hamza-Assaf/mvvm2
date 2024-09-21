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
import com.example.mvvm2.databinding.FragmentNewPassBinding
import com.example.mvvm2.features.forgotPassword.NewPasswordFragmentDirections.Companion.actionNewPassToOtp2
import com.example.mvvm2.features.forgotPassword.NewPasswordFragmentDirections.Companion.actionNewPassToPassChanged


class NewPasswordFragment : Fragment() {

    private lateinit var binding: FragmentNewPassBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentNewPassBinding.inflate(layoutInflater)
        val view = binding.root

        val db = Room.databaseBuilder(binding.root.context, DataBaseHelper::class.java, "users")
            .allowMainThreadQueries().build()

        val userDao = db.userDao()


        val email = arguments?.getString("Email")

        binding.resetButton.setOnClickListener {


            if (binding.newPass.text.toString()
                    .equals(binding.confrmPass.text.toString()) && userDao.findUserByEmail(email.toString()).password.equals(
                    binding.newPass.text.toString()
                )
            ) {

                Toast.makeText(
                    binding.root.context,
                    "New Password Cant be Same as Old Password",
                    Toast.LENGTH_SHORT
                ).show()


            } else if (binding.newPass.text.toString()
                    .isEmpty() || binding.confrmPass.text.toString().isEmpty()
            ) {

                Toast.makeText(binding.root.context, "Please fill all fields", Toast.LENGTH_SHORT)
                    .show()


            }

            else if (binding.newPass.text.toString() != binding.confrmPass.text.toString()) {
                Toast.makeText(
                    binding.root.context,
                    "Passwords do not match",
                    Toast.LENGTH_SHORT
                ).show()
            }

            else if (binding.newPass.text.toString()
                    .equals(binding.confrmPass.text.toString()) && !userDao.findUserByEmail(email.toString()).password.equals(
                    binding.newPass.text.toString()
                )
            ) {

                val user = userDao.findUserByEmail(email.toString())
                user.password = binding.newPass.text.toString()

                userDao.updatePassword(user)
                Toast.makeText(
                    binding.root.context,
                    "Password Changed Successfully",
                    Toast.LENGTH_SHORT
                ).show()
                val action = actionNewPassToPassChanged()
                findNavController().navigate(action)
            }


        }

        binding.backButton.backButton.setOnClickListener {


            val action = actionNewPassToOtp2()
            findNavController().navigate(action)

        }


        return view
    }


}