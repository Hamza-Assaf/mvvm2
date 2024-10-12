package com.example.mvvm2.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.mvvm2.databinding.FragmentViewPagerBinding
import com.example.mvvm2.features.database.DataBaseHelper
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint

class ViewPagerFragment : Fragment() {

    lateinit var binding: FragmentViewPagerBinding

    private val fragmentArray= arrayOf(
    "Top Headlines",
    "All news",
    "Settings"
)




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
binding = FragmentViewPagerBinding.inflate(layoutInflater)


        val db = Room.databaseBuilder(binding.root.context, DataBaseHelper::class.java, "users")
            .allowMainThreadQueries().build()
        val userDao = db.userDao()
        val email = arguments?.getString("email")



        if (email != null) binding.welcomeText.text=
                "Welcome " + userDao.findUserByEmail(email).userName


        binding.backButton.backButton.setOnClickListener {
            activity?.finish()

        }
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val supportFragmentManager = childFragmentManager

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = fragmentArray[position]}.attach()


    return  binding.root
    }


}