package com.kai.time.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.kai.time.bean.TypeBean
import com.kai.time.fragment.ContentFragment

class AllVpAdapter(fm: FragmentManager, private val typeList: ArrayList<TypeBean>) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        val bundle = Bundle().apply {
            putString("type", typeList[position].categories)
        }
        return ContentFragment().apply { arguments = bundle }
    }

    override fun getItemPosition(`object`: Any): Int {
        return super.getItemPosition(`object`)
    }

    override fun getCount() = typeList.size
    override fun getPageTitle(position: Int) = typeList[position].name
}