package com.kai.time.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kai.time.R
import com.kai.time.adapter.MovieVpAdapter
import kotlinx.android.synthetic.main.frag_movie.view.*

class MovieFragment : Fragment() {

    private val titles = arrayListOf("热映","即将上映","豆瓣" )
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.frag_movie, null)
        view.vp_frag_movie.adapter = MovieVpAdapter(activity!!.supportFragmentManager,titles)
        view.frag_tl_movie.setupWithViewPager(view.vp_frag_movie)
        return view
    }
}