package com.kai.time.activity

import android.annotation.SuppressLint
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.kai.time.R
import com.kai.time.adapter.DoubanActorAdapter
import com.kai.time.adapter.DoubanCommentVpAdapter
import com.kai.time.adapter.DoubanVideoAdapter
import com.kai.time.base.BaseActivity
import com.kai.time.bean.DoubanDetailsBean
import com.kai.time.http.Api
import com.kai.time.utils.StatusBarUtil
import com.kai.time.utils.mContext
import kotlinx.android.synthetic.main.activity_douban_details.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

class DoubanDetailsActivity : BaseActivity() {

    private val commentList: ArrayList<String> = ArrayList()
    private val videoList: ArrayList<DoubanDetailsBean.Trailers> = ArrayList()
    private var actorAdapter: DoubanActorAdapter? = null
    private val directors: ArrayList<DoubanDetailsBean.Directors> = ArrayList()
    private val actors: ArrayList<DoubanDetailsBean.Casts> = ArrayList()
    private val imgs: ArrayList<DoubanDetailsBean.Photos> = ArrayList()
    private val imgUrls: ArrayList<String> = ArrayList()
    override fun initView() {
        val lp: CollapsingToolbarLayout.LayoutParams = tl_douban_details.layoutParams as CollapsingToolbarLayout.LayoutParams
        lp.setMargins(0, getStatusBarHeight(), 0, 0)
        tl_douban_details.layoutParams = lp
        StatusBarUtil.setTranslucentForCoordinatorLayout(this, 0)
        rv_video_douban_details.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        rv_actor_douban_details.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
        showLoading()
//        iv_back_douban_details.setOnClickListener { finish() }
        commentList.add("评论")
        commentList.add("精彩短评")
//        vp_douban_details.adapter = DoubanCommentVpAdapter(supportFragmentManager,commentList)
//        tal_douban_details.setupWithViewPager(vp_douban_details,true)
        getDoubanDetails()
    }

    @SuppressLint("SetTextI18n")
    private fun getDoubanDetails() {
        async(UI) {
            val result = Api.doubanRetrofitService.getDoubanDetails(intent.getStringExtra("id")).await()
            if (result.reviews_count > 0) {
                dismissLoading()
                directors.addAll(result.directors)
                actors.addAll(result.casts)
                actorAdapter = DoubanActorAdapter { view, position ->

                }
                videoList.addAll(result.trailers)

                rv_video_douban_details.adapter = DoubanVideoAdapter(videoList) { view, position ->
                }
                if (!result.has_video) {
                    ll_video_douban_details.visibility = View.GONE
                }
                actorAdapter!!.setActorData(actors)
                actorAdapter!!.setDirectorData(directors)
                rv_actor_douban_details.adapter = actorAdapter
                actorAdapter!!.addHeader(R.layout.douban_actor_head)
                actorAdapter!!.addBody(R.layout.douban_actor_item)

                imgs.addAll(result.photos)
                for (i in 0 until imgs.size) {
                    imgUrls.add(imgs[i].image)
                }
                banner_douban.setView(imgUrls)
                banner_douban.setAutoDisplay(true)
                banner_douban.setCyclerDuration(4000)
                Glide.with(mContext)
                        .asBitmap()
                        .load(result.photos[0].image)
                        .apply(RequestOptions()
                                .centerCrop()
                                .placeholder(R.drawable.ic_no_video)
                                .error(R.drawable.ic_no_video)
                                .priority(Priority.HIGH)
                                .diskCacheStrategy(DiskCacheStrategy.NONE))
                        .into(iv_thumb_douban_details)
                tl_douban_details.title = result.original_title
                tv_type_douban_details.text = "类型: " + result.genres.toString()
                tv_date_douban_details.text = "上映时间: ${result.pubdates}"
                tv_time_douban_details.text = "片长: " + result.durations[0]
                tv_title_douban_details.text = result.original_title
                tv_story_douban_details.text = "剧情简介： " + "\n" + result.summary
            }
        }
    }

    override fun bindLayout() = R.layout.activity_douban_details

    override fun useTitleBar() = false


    private fun getStatusBarHeight(): Int {
        var statusBarHeight = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            statusBarHeight = resources.getDimensionPixelSize(resourceId)
        }
        return statusBarHeight
    }
}