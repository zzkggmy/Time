package com.kai.time.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kai.time.R
import kotlinx.android.synthetic.main.frag_content.view.*

class ContentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.frag_content, null)
        view.rv_content.layoutManager = LinearLayoutManager(activity)
        return view
    }
}