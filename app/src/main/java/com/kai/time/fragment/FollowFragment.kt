package com.kai.time.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kai.time.R
import com.kai.time.utils.mContext
import com.kai.time.view.Banner
import kotlinx.android.synthetic.main.frag_follow.view.*

class FollowFragment : Fragment() {

    private val titles: ArrayList<String> = ArrayList()
    private val urls: ArrayList<String> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.frag_follow, null)
        urls.add("http://img.kaiyanapp.com/431177a6b2177788aa4d8eff8073d9a7.jpeg?imageMogr2/quality/60/format/jpg")
        urls.add("http://img.kaiyanapp.com/a3de18fb448aa41a140f1901130c380a.png?imageMogr2/quality/60/format/jpg")
        urls.add("http://img.kaiyanapp.com/e41e74fe73882b552de00d95d56748d2.jpeg?imageMogr2/quality/60")
        urls.add("http://img.kaiyanapp.com/de7d400a88ed4df4cb407fd8081fa980.jpeg?imageMogr2/quality/60/format/jpg")
        titles.add("asdasd")
        titles.add("eqweqew")
        titles.add("zfsdgsfgfsdg")
        titles.add("adsafsgsdfgsd")
        view.banner.setView(urls)
        view.banner.setIndicatorWithTitle(R.color.zhihu_primary,1.0f,R.color.white,20f,titles)
        view.banner.setCyclerDuration(2000)
        view.banner.setAutoDisplay(true)
        view.banner.setOnBannerItemClickListener(object : Banner.OnBannerItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                Toast.makeText(mContext,position.toString(),Toast.LENGTH_SHORT).show()
            }
        })
        return view
    }
}