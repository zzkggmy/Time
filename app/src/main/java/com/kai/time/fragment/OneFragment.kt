package com.kai.time.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kai.time.R
import com.kai.time.adapter.OneAdapter
import com.kai.time.bean.HomeBean
import com.kai.time.http.Api
import kotlinx.android.synthetic.main.frag_one.view.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

class OneFragment : Fragment() {
    private val onList: ArrayList<HomeBean.ItemList> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.frag_one, null)
        view.rv_one_frag.layoutManager = LinearLayoutManager(activity)
        getTodayOne(view)
        return view
    }

    private fun getTodayOne(view: View) {
        async(UI) {
            val result = Api.retrofitService.getHomePage().await()

            if (result.count > 0) {

                onList.addAll(result.itemList)
                view.rv_one_frag.adapter = OneAdapter(onList) { view, position -> }
            }
        }
    }
}