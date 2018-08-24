package com.kai.time.http

import com.kai.time.bean.*
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    //获取地区id
    @GET("Showtime/HotCitiesByCinema.api")
    fun getAreaId(): Deferred<AreaIdBean>

    //正在售票
    @GET("PageSubArea/HotPlayMovies.api?locationId=290")
    fun getSell(): Deferred<SellingBean>

    //正在热映
    @GET("Showtime/LocationMovies.api?locationId=290")
    fun getHot(): Deferred<HotBean>

    //即将上映
    @GET("Movie/MovieComingNew.api?locationId=290")
    fun comming(@Query("locationId") locationId: String): Deferred<CommingBean>

    //影视详情
    @GET("movie/detail.api?locationId=290&movieId=id")
    fun getMovieDetails(@Query("areaId") areaId: String, @Query("id") id: String): Deferred<MovieDetailsBean>

    //获取豆瓣电影
    @GET("v2/movie/in_theaters?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&start=0&count=100&client=&udid=")
    fun getDouban(): Deferred<DoubanBean>

    //获取豆瓣电影详情
    @GET("v2/movie/subject/{id}?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&client=&udid=")
    fun getDoubanDetails(@Path("id")id: String): Deferred<DoubanDetailsBean>
}