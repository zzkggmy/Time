package com.kai.time.http

import com.kai.time.bean.HomeBean
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    //获取首页
    @GET("api/v4/tabs/selected")
    fun getHomePage(): Deferred<HomeBean>
}