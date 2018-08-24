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

class MovieContentFragment : Fragment() {


    private var hotAdapter: MovieContentAdapter? = null
    private var doubanAdapter: DoubanAdapter? = null
    private var commingAdapter: CommingContentAdapter? = null
    private val hotList: ArrayList<HotBean.Ms> = ArrayList()
    private val commingList: ArrayList<CommingBean.Moviecomings> = ArrayList()
    private val doubanList: ArrayList<DoubanBean.Subjects> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.frag_movie_content, null)
        view.rv_movie_content.layoutManager = LinearLayoutManager(activity)
        if (arguments!!.getInt("type") == 0) {
            getHot(view)
        } else if (arguments!!.getInt("type") == 1) {
            getComming(view)
        } else {
            getDouban(view)
        }
        return view
    }

    private fun getDouban(view: View?) {
        async(UI) {
            val result = Api.doubanRetrofitService.getDouban().await()
            if (result.total > 0) {
                doubanList.addAll(result.subjects)
                doubanAdapter = DoubanAdapter { _, position ->
                    startActivity(Intent(activity, DoubanDetailsActivity::class.java).apply {
                        putExtra("id", result.subjects[position].id)
                    })
                }
                doubanAdapter!!.addBody(R.layout.douban_body_item)
                view!!.rv_movie_content.adapter = doubanAdapter
                doubanAdapter!!.setData(doubanList)
            }
        }
    }

    private fun getComming(view: View?) {
        async(UI) {
            val result = Api.retrofitService.comming("290").await()
            if (result.moviecomings.isNotEmpty()) {
                Log.d("tag", result.moviecomings.toString())
                commingList.addAll(result.moviecomings)
                commingAdapter = CommingContentAdapter { _, position ->
                    startActivity(Intent(activity, MovieDetailsActivity::class.java).apply {
                        putExtra("id", commingList[position].id)
                        putExtra("title", commingList[position].title)
                    })
                }
                commingAdapter!!.addBody(R.layout.comming_body_item)
                view!!.rv_movie_content.adapter = commingAdapter
                commingAdapter!!.setData(commingList)
            }
        }
    }

    private fun getHot(view: View) {
        async(UI) {
            val result = Api.retrofitService.getHot().await()
            if (result.ms.isNotEmpty()) {
                hotList.addAll(result.ms)
                hotAdapter = MovieContentAdapter { _, position ->
//                    startActivity(Intent(activity, MovieDetailsActivity::class.java))
                }
                view.rv_movie_content.adapter = hotAdapter
                hotAdapter!!.setData(hotList)
                hotAdapter!!.addBody(R.layout.hot_body_item)
            }
        }

    }
}