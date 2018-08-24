package com.kai.time.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.jzvd.JZVideoPlayerStandard
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.kai.time.R
import com.kai.time.bean.MovieDetailsBean
import com.kai.time.utils.getScreeHeight
import com.kai.time.utils.getScreeWidth
import com.kai.time.utils.mContext
import kotlinx.android.synthetic.main.video_item.view.*

class VideoAdapter(val videoList: ArrayList<MovieDetailsBean.Data.Basic.Video>, val onClick: (view: View, position: Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parents: ViewGroup, position: Int) = VideoHolder(LayoutInflater.from(mContext).inflate(R.layout.video_item, parents, false))

    override fun getItemCount() = videoList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.jz_video_item.setUp(videoList[position].hightUrl, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, videoList[position].title)
        Glide.with(mContext)
                .asBitmap()
                .load(videoList[position].img)
                .apply(RequestOptions()
                        .centerCrop()
                        .override(getScreeWidth(), getScreeHeight())
                        .placeholder(R.drawable.ic_no_video)
                        .error(R.drawable.ic_no_video)
                        .priority(Priority.HIGH)
                        .diskCacheStrategy(DiskCacheStrategy.NONE))
                .into(holder.itemView.jz_video_item.thumbImageView)
    }

    class VideoHolder(view: View) : RecyclerView.ViewHolder(view)
}