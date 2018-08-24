package com.kai.time.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
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
import kotlinx.android.synthetic.main.douban_actor_head.view.*
import kotlinx.android.synthetic.main.douban_actor_item.view.*

class DoubanActorAdapter(val onClick: (view: View, position: Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var directorData: ArrayList<DoubanDetailsBean.Directors> = ArrayList()
    private var actorData: ArrayList<DoubanDetailsBean.Casts> = ArrayList()
    private var useHead = false
    private var useFoot = false
    private var headView: Int = 0
    private var bodyView = 0
    private var footerView: Int = 0
    private val HEADER = 0
    private val FOOTER = 1
    private val BODY = 2
    private var footerVisi = false
    private var headerVisi = false

    override fun onCreateViewHolder(parents: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            HEADER -> return HeaderHolder(LayoutInflater.from(mContext).inflate(headView, parents, false))
            FOOTER -> return FooterHolder(LayoutInflater.from(mContext).inflate(footerView, parents, false))
            else -> return BodyHolder(LayoutInflater.from(mContext).inflate(bodyView, parents, false))
        }
    }

    fun setDirectorData(datas: ArrayList<DoubanDetailsBean.Directors>) {
        directorData = datas
    }

    fun setActorData(datas: ArrayList<DoubanDetailsBean.Casts>) {
        actorData = datas
    }

    fun addHeader(headView: Int) {
        headerVisi = true
        useHead = true
        this.headView = headView
        actorData.add(actorData[0])
        notifyItemInserted(0)
    }

    fun addBody(bodyView: Int) {
        this.bodyView = bodyView
    }

    fun removeHeader() {
        useHead = false
        actorData.removeAt(0)
        notifyItemRemoved(0)
    }

    fun headerVisi(visibility: Boolean) {
        headerVisi = visibility
    }

    fun addFooter(footerView: Int) {
        footerVisi = true
        useFoot = true
        this.footerView = footerView
        actorData.add(actorData[actorData.size - 1])
        notifyItemInserted(actorData.size - 1)
    }

    fun removeFooter() {
        useFoot = false
        actorData.removeAt(actorData.size - 1)
        notifyItemRemoved(actorData.size - 1)
    }

    fun footerVisi(visibility: Boolean) {
        footerVisi = visibility
    }

    override fun getItemCount() = actorData.size

    override fun getItemViewType(position: Int): Int {
        if (useHead && !useFoot) {
            return if (position == 0) HEADER else BODY
        } else if (!useHead && useFoot) {
            return if (position == actorData.size - 1) FOOTER else BODY
        } else if (useHead && useFoot) {
            if (position == 0) {
                return HEADER
            } else if (position == actorData.size - 1) {
                return FOOTER
            } else {
                return BODY
            }
        } else if (!useHead && !useFoot) {
            return BODY
        } else {
            return BODY
        }
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0) {
            holder.itemView.rv_douban_actor_head.layoutManager = LinearLayoutManager(mContext).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            holder.itemView.rv_douban_actor_head.adapter = DoubanDirectorAdapter(directorData) { _, _ -> }
        } else {
            holder.itemView.tv_name_douban_actor_item.text = " 主演: " + "\n" + actorData[position].name + "\n" + actorData[position].name_en
            Glide.with(mContext)
                    .asBitmap()
                    .load(actorData[position].avatars.large)
                    .apply(RequestOptions()
                            .centerCrop()
                            .placeholder(R.drawable.ic_no_video)
                            .error(R.drawable.ic_no_video)
                            .priority(Priority.HIGH)
                            .diskCacheStrategy(DiskCacheStrategy.NONE))
                    .into(holder.itemView.iv_douban_actor_item)
            holder.itemView.cv_douban_actor_item.setOnClickListener {
                onClick(holder.itemView, holder.adapterPosition)
            }
        }
    }

    class HeaderHolder(view: View) : RecyclerView.ViewHolder(view)

    class BodyHolder(view: View) : RecyclerView.ViewHolder(view)

    class FooterHolder(view: View) : RecyclerView.ViewHolder(view)

}