package com.kai.time.http

class Api {
    companion object {
        val retrofitService: ApiService by lazy { RetrofitHelper.create("https://api-m.mtime.cn/") }
        val ticketRetrofitService: ApiService by lazy { RetrofitHelper.create("https://ticket-api-m.mtime.cn/") }
        val doubanRetrofitService: ApiService by lazy { RetrofitHelper.create("https://api.douban.com/") }
        val tcRetrofitService: ApiService by lazy { RetrofitHelper.create("https://api.tuchong.com/") }
    }
}