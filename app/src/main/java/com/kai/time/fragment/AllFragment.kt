package com.kai.time.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kai.time.R
import com.kai.time.adapter.AllVpAdapter
import com.kai.time.bean.TypeBean
import kotlinx.android.synthetic.main.frag_all.view.*

class AllFragment : Fragment() {
    private val categories = arrayListOf("reading", "music", "movie")
    private val names = arrayListOf("阅读", "音乐", "影视")
    private val typeList: ArrayList<TypeBean> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.frag_all, null)
        for (i in 0 until categories.size) {
            val typeBean = TypeBean(names[i], categories[i])
            typeList.add(typeBean)
        }
        view.vp_all.adapter = AllVpAdapter(activity!!.supportFragmentManager, typeList)
        view.tl_all.setupWithViewPager(view.vp_all, true)
        return view
    }
}