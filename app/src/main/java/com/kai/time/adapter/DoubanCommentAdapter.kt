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
import kotlinx.android.synthetic.main.douban_comment_item.view.*

class DoubanCommentAdapter(val commentList: ArrayList<DoubanDetailsBean.PopularComments>, val onClick: (view: View, position: Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parents: ViewGroup, position: Int) = ActorHolder(LayoutInflater.from(mContext).inflate(R.layout.douban_comment_item, parents, false))

    override fun getItemCount() = commentList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == commentList.size - 1) {
            holder.itemView.v_comment_douban_item.visibility = View.GONE
        }
        holder.itemView.tv_title_comment_douban_item.text = commentList[position].author.name
        holder.itemView.tv_content_comment_douban_item.text = commentList[position].content
        holder.itemView.tv_date_comment_douban_item.text = commentList[position].created_at
        Glide.with(mContext)
                .asBitmap()
                .load(commentList[position].author.avatar)
                .apply(RequestOptions()
                        .centerCrop()
                        .placeholder(R.drawable.ic_no_video)
                        .error(R.drawable.ic_no_video)
                        .priority(Priority.HIGH)
                        .diskCacheStrategy(DiskCacheStrategy.NONE))
                .into(holder.itemView.iv_comment_douban_item)
    }

    class ActorHolder(view: View) : RecyclerView.ViewHolder(view)
}