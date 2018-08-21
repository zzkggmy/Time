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
        urls.add("http://ssyerv2.oss-cn-hangzhou.aliyuncs.com/picture/full/SkWW_SCpz7.jpg?OSSAccessKeyId=LTAIZGFK7enA1Ifb&Expires=1534855717&Signature=oExG9jYgkHRwVTpjUV2gjqEps2Y%3D&response-content-disposition=attachment%3B%20filename%3D%22SkWW_SCpz7.jpg%22")
        urls.add("http://ssyerv2.oss-cn-hangzhou.aliyuncs.com/picture/full/HkfLRq8OzX.jpg?OSSAccessKeyId=LTAIZGFK7enA1Ifb&Expires=1534855774&Signature=Ho8iNftzU5YzhUo5M%2F20FJrCsVg%3D&response-content-disposition=attachment%3B%20filename%3D%22HkfLRq8OzX.jpg%22")
        urls.add("http://ssyerv2.oss-cn-hangzhou.aliyuncs.com/picture/full/S1be6bZMXX.jpg?OSSAccessKeyId=LTAIZGFK7enA1Ifb&Expires=1534855806&Signature=j4vRYztBIJjD7voHY%2B%2F1ZdPn%2FcA%3D&response-content-disposition=attachment%3B%20filename%3D%22S1be6bZMXX.jpg%22")
        urls.add("http://ssyerv2.oss-cn-hangzhou.aliyuncs.com/picture/full/rJWH9w7GQ.jpg?OSSAccessKeyId=LTAIZGFK7enA1Ifb&Expires=1534855843&Signature=RUXxKHudSsXOw1ZoMHxs%2Bbqgn3w%3D&response-content-disposition=attachment%3B%20filename%3D%22rJWH9w7GQ.jpg%22")
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