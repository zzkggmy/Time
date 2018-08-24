package com.kai.time.activity

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.kai.time.R
import com.kai.time.adapter.ActorAdapter
import com.kai.time.adapter.VideoAdapter
import com.kai.time.base.BaseActivity
import com.kai.time.bean.MovieDetailsBean
import com.kai.time.http.Api
import com.kai.time.utils.mContext
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

class MovieDetailsActivity : BaseActivity() {

    private val actorList: ArrayList<MovieDetailsBean.Data.Basic.Actors> = ArrayList()
    private val imgUrls: ArrayList<MovieDetailsBean.Data.Basic.StageImg.ImgList> = ArrayList()
    private val bannerUrls: ArrayList<String> = ArrayList()
    private val videoList: ArrayList<MovieDetailsBean.Data.Basic.Video> = ArrayList()
    override fun initView() {
        tv_title_video_details.text = intent.getStringExtra("title")
        rv_video_movie_details.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        rv_actor_movie_details.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        getMovieDetails()
    }

    @SuppressLint("SetTextI18n")
    private fun getMovieDetails() {
        async(UI) {
            val result = Api.ticketRetrofitService.getMovieDetails("290",intent.getIntExtra("id",255708).toString()).await()
            Log.d("as", intent.getStringExtra("id").toString() + result.data.basic.stageImg.toString())
            if (result.code == "1") {
                actorList.addAll(result.data.basic.actors)
                imgUrls.addAll(result.data.basic.stageImg.list)
                for (i in 0 until imgUrls.size) {
                    bannerUrls.add(imgUrls[i].imgUrl)
                }
                videoList.add(result.data.basic.video)
                Glide.with(mContext)
                        .asBitmap()
                        .load(result.data.basic.img)
                        .apply(RequestOptions()
                                .centerCrop()
                                .placeholder(R.drawable.ic_no_video)
                                .error(R.drawable.ic_no_video)
                                .priority(Priority.HIGH)
                                .diskCacheStrategy(DiskCacheStrategy.NONE))
                        .into(iv_thumb_video_details)
                rv_video_movie_details.adapter = VideoAdapter(videoList) { view, position ->

                }
                rv_actor_movie_details.adapter = ActorAdapter(actorList) { view, position ->

                }
                tv_title_video_details.text = result.data.basic.name
                tv_title_en_video_details.text = result.data.basic.nameEn
                tv_time_video_details.text = result.data.basic.mins
                tv_type_video_details.text = result.data.basic.type.toString()
                tv_story_movie_details.text = "主要剧情：   " + "\n" + result.data.basic.story
                banner_stage_movie_details.setView(bannerUrls)
                banner_stage_movie_details.setAutoDisplay(true)
                banner_stage_movie_details.setCyclerDuration(3000)
            }
        }
    }

    override fun bindLayout() = R.layout.activity_movie_details

    override fun useTitleBar() = false

}