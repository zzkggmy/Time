package com.kai.time.http

class Api {
    companion object {
        val retrofitService: ApiService by lazy { RetrofitHelper.create("http://baobab.kaiyanapp.com/") }
    }
}