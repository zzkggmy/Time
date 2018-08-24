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
import com.kai.time.bean.MovieDetailsBean
import com.kai.time.utils.mContext
import kotlinx.android.synthetic.main.actor_item.view.*

class StageAdapter(val actorList: ArrayList<MovieDetailsBean.Data.Basic.Actors>, val onClick: (view: View, position: Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parents: ViewGroup, position: Int) = ActorHolder(LayoutInflater.from(mContext).inflate(R.layout.actor_item, parents, false))

    override fun getItemCount() = actorList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_actor_name_item.text = "姓名： " + actorList[position].name + "\n" + "英文名字： " + actorList[position].nameEn
        if (position == 0) {
            holder.itemView.tv_actor_type_item.text = "导演"
        } else if (position == 1) {
            holder.itemView.tv_actor_type_item.text = "主演"
        }
        Glide.with(mContext)
                .asBitmap()
                .load(actorList[position].img)
                .apply(RequestOptions()
                        .centerCrop()
                        .placeholder(R.drawable.ic_no_video)
                        .error(R.drawable.ic_no_video)
                        .priority(Priority.HIGH)
                        .diskCacheStrategy(DiskCacheStrategy.NONE))
                .into(holder.itemView.iv_actor_item)
    }

    class ActorHolder(view: View) : RecyclerView.ViewHolder(view)
}