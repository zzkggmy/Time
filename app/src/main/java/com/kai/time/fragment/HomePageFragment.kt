package com.kai.time.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kai.time.R
import com.kai.time.http.Api
import kotlinx.android.synthetic.main.frag_home_page.view.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

class HomePageFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.frag_home_page, null)
        view.rv_home_page.layoutManager = LinearLayoutManager(activity)

        return view
    }
}