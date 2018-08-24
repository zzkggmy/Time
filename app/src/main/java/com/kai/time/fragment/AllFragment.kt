package com.kai.time.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kai.time.R
import com.kai.time.adapter.DiscoverVpAdapter
import com.kai.time.utils.StatusBarUtil
import com.kai.time.utils.findColor
import com.kai.time.utils.mContext
import kotlinx.android.synthetic.main.frag_all.view.*

class AllFragment : Fragment(){
    private val type = arrayListOf("图虫", "发现")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.frag_all,null)
        view.tl_discover_frag.setupWithViewPager(view.vp_discover_frag)
        view.vp_discover_frag.adapter = DiscoverVpAdapter(activity!!.supportFragmentManager, type)
        return view
    }
}