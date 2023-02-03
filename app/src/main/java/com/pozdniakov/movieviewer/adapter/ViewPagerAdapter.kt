package com.pozdniakov.movieviewer.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pozdniakov.movieviewer.fragment.FavouriteFragment
import com.pozdniakov.movieviewer.fragment.PopularFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PopularFragment()
            1 -> FavouriteFragment()
            else -> throw java.util.NoSuchElementException()
        }
    }
}