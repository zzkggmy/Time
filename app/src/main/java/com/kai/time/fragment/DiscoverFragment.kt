package com.kai.time.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kai.time.R
import com.kai.time.adapter.TcDiscoverAdapter
import com.kai.time.bean.TcDiscoverBean
import com.kai.time.http.Api
import kotlinx.android.synthetic.main.frag_discover.view.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

class DiscoverFragment : Fragment() {


    private var adapter: TcDiscoverAdapter? = null
    private val discover: ArrayList<TcDiscoverBean.Categories> = ArrayList()
    private val banner: ArrayList<TcDiscoverBean.Banners> = ArrayList()
    private val urls: ArrayList<String> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.frag_discover, null)
        view.rv_discover_frag.layoutManager = LinearLayoutManager(activity)
        if (arguments!!.getInt("type") == 1) {
            getDiscover(view)
        }
        return view
    }

    private fun getDiscover(view: View?) {
        async(UI) {
            val result = Api.tcRetrofitService.getTcDiscover().await()
            Log.d("sc",result.toString())
                discover.addAll(result.categories)
                banner.addAll(result.banners)
                for (i in 0 until banner.size) {
                    urls.add(banner[i].url)
                }
                adapter = TcDiscoverAdapter { _, _ -> }
                adapter!!.setData(discover)
                adapter!!.setBannerData(urls)
                adapter!!.addBody(R.layout.discover_item)
                adapter!!.addHeader(R.layout.discover_head_banner)
        }
    }
}