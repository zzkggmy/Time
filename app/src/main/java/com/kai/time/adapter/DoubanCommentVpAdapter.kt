package com.kai.time.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.kai.time.fragment.DoubanCommentFragment

class DoubanCommentVpAdapter(fm: FragmentManager, val comments: ArrayList<String>) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        val bundle = Bundle().apply {
            putInt("id",position)
        }
        return DoubanCommentFragment().apply { arguments = bundle }
    }

    override fun getCount() = comments.size
    override fun getPageTitle(position: Int) = comments[position]
}