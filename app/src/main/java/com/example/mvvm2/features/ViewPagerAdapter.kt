package com.example.mvvm2.features

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mvvm2.features.articles.ui.ArticleListFragment
import com.example.mvvm2.features.articles.ui.EverythingListFragment

private const val tabNum = 3
class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle)
    :FragmentStateAdapter(fragmentManager,lifecycle){



    override fun getItemCount(): Int {
        return tabNum
    }

    override fun createFragment(position: Int): Fragment {

        return when (position){
            0 -> ArticleListFragment()
            1 -> EverythingListFragment()
            2 -> SettingsFragment()

            else -> {
                ArticleListFragment()
            }
        }


    }
}