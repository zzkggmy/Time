package com.kai.time.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.kai.time.fragment.MovieContentFragment
import com.kai.time.fragment.MovieFragment

class MovieVpAdapter(fm: FragmentManager,val titles: ArrayList<String>) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        val bundle = Bundle().apply {
            putInt("type",position)
        }
        return MovieContentFragment().apply { arguments = bundle }
    }

    override fun getCount() = titles.size
    override fun getPageTitle(position: Int) = titles[position]
}