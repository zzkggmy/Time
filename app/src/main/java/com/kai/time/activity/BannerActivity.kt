package com.kai.time.activity

import android.os.Build
import android.support.annotation.RequiresApi
import com.kai.time.R
import com.kai.time.base.BaseActivity
import com.kai.time.bean.TcDiscoverBean
import com.kai.time.http.Api
import kotlinx.android.synthetic.main.activity_banner.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

class BannerActivity : BaseActivity() {

    private val urls: ArrayList<String> = ArrayList()
    private val banner: ArrayList<TcDiscoverBean.Banners> = ArrayList()
    @RequiresApi(Build.VERSION_CODES.M)
    override fun initView() {
        getDiscover()
        setCenterText("好的",15f,R.color.text_black)
    }

    override fun bindLayout() = R.layout.activity_banner

    private fun getDiscover() {
        async(UI) {
            val result = Api.tcRetrofitService.getTcDiscover().await()
            banner.addAll(result.banners)
            for (i in 0 until banner.size) {
                urls.add(banner[i].src)
            }
            banner_banner.setView(urls)
            banner_banner.setCyclerDuration(4000)
            banner_banner.setAutoDisplay(true)
        }
    }

}