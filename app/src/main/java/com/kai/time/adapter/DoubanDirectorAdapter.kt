package com.kai.time.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.kai.time.R
import com.kai.time.bean.DoubanDetailsBean
import com.kai.time.utils.mContext
import kotlinx.android.synthetic.main.douban_direct_head_item.view.*

class DoubanDirectorAdapter(val actorList: ArrayList<DoubanDetailsBean.Directors>, val onClick: (view: View, position: Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parents: ViewGroup, position: Int) = ActorHolder(LayoutInflater.from(mContext).inflate(R.layout.douban_direct_head_item, parents, false))

    override fun getItemCount() = actorList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_name_douban_director_head_item.text = "导演： " + "\n" + actorList[position].name + "\n" + actorList[position].name_en
        try {
            Glide.with(mContext)
                    .asBitmap()
                    .load(actorList[position].avatars.large)
                    .apply(RequestOptions()
                            .centerCrop()
                            .placeholder(R.drawable.ic_no_video)
                            .error(R.drawable.ic_no_video)
                            .priority(Priority.HIGH)
                            .diskCacheStrategy(DiskCacheStrategy.NONE))
                    .into(holder.itemView.iv_douban_director_head_item)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }

    class ActorHolder(view: View) : RecyclerView.ViewHolder(view)
}