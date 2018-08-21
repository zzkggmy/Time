package com.kai.time.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kai.time.R
import com.kai.time.bean.HomeBean
import com.kai.time.utils.mContext
import com.kai.time.utils.options
import kotlinx.android.synthetic.main.home_page_item.view.*

class OneAdapter(val list: ArrayList<HomeBean.ItemList>, val onClick: (view: View, position: Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(paredts: ViewGroup, viewType: Int) = HomePageHolder(LayoutInflater.from(mContext).inflate(R.layout.home_page_item, paredts, false))

    override fun getItemCount() = list.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_title_home_page.text = list[position].data.title
        holder.itemView.tv_describe_home_page.text = list[position].data.description
//            Glide.with(mContext)
//                    .asBitmap()
//                    .load(list[position].data)
//                    .apply { options }
//                    .into(holder.itemView.iv_home_page_item)
    }

    class HomePageHolder(view: View) : RecyclerView.ViewHolder(view)

}