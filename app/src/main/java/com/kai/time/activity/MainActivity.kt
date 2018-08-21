package com.kai.time.activity

import android.support.v4.app.Fragment
import com.kai.time.R
import com.kai.time.base.BaseActivity
import com.kai.time.fragment.AllFragment
import com.kai.time.fragment.FollowFragment
import com.kai.time.fragment.OneFragment
import com.kai.time.utils.findColor
import kotlinx.android.synthetic.main.activity_one.*

class MainActivity : BaseActivity() {

    private val oneFrag = OneFragment()
    private val allFrag = AllFragment()
    private val followFragment = FollowFragment()
    private val fragList: ArrayList<Fragment> = ArrayList()
    private val greyPicList = arrayListOf(R.drawable.ic_video_grey, R.drawable.ic_fire_grey, R.drawable.ic_follow_grey)
    private val redPicList = arrayListOf(R.drawable.ic_video_red, R.drawable.ic_fire_red, R.drawable.ic_follow_red)
    override fun initView() {
        initFrag()
        fragList.add(oneFrag)
        fragList.add(allFrag)
        fragList.add(followFragment)
        ll_one.setOnClickListener { showFrag(0) }
        ll_all.setOnClickListener { showFrag(1) }
        ll_follow.setOnClickListener { showFrag(2) }
    }

    private fun showFrag(position: Int) {
        val tvList = arrayListOf(tv_one, tv_all,tv_follow)
        val ivList = arrayListOf(iv_one, iv_all,iv_follow)
        fragList.forEachIndexed { index, fragment ->
            if (index == position) {
                supportFragmentManager.beginTransaction()
                        .show(fragList[index])
                        .commit()
                tvList[index].setTextColor(findColor(R.color.google_red))
                ivList[index].setImageResource(redPicList[index])
            } else {
                supportFragmentManager.beginTransaction()
                        .hide(fragList[index])
                        .commit()

                tvList[index].setTextColor(findColor(R.color.icon_color))
                ivList[index].setImageResource(greyPicList[index])
            }
        }
    }

    private fun initFrag() {
        supportFragmentManager.beginTransaction()
                .add(R.id.fl_main, oneFrag)
                .add(R.id.fl_main, allFrag)
                .add(R.id.fl_main,followFragment)
                .show(oneFrag)
                .hide(allFrag)
                .hide(followFragment)
                .commit()
    }

    override fun bindLayout() = R.layout.activity_one

    override fun useTitleBar() = false
}