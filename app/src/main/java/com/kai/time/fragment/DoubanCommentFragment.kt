package com.kai.time.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kai.time.R
import com.kai.time.activity.DoubanDetailsActivity
import com.kai.time.activity.MovieDetailsActivity
import com.kai.time.adapter.CommingContentAdapter
import com.kai.time.adapter.DoubanAdapter
import com.kai.time.adapter.MovieContentAdapter
import com.kai.time.bean.CommingBean
import com.kai.time.bean.DoubanBean
import com.kai.time.bean.HotBean
import com.kai.time.http.Api
import kotlinx.android.synthetic.main.frag_movie_content.view.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

class DoubanCommentFragment : Fragment() {


    private var hotAdapter: MovieContentAdapter? = null
    private var doubanAdapter: DoubanAdapter? = null
    private var commingAdapter: CommingContentAdapter? = null
    private val hotList: ArrayList<HotBean.Ms> = ArrayList()
    private val commingList: ArrayList<CommingBean.Moviecomings> = ArrayList()
    private val doubanList: ArrayList<DoubanBean.Subjects> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.frag_douban_comment, null)
        return view
    }

}