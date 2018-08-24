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
import com.kai.time.bean.HotBean
import com.kai.time.utils.mContext
import kotlinx.android.synthetic.main.hot_body_item.view.*

class MovieContentAdapter(val onClick: (view: View, position: Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data: ArrayList<HotBean.Ms> = ArrayList()
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

    fun setData(datas: ArrayList<HotBean.Ms>) {
        data = datas
    }

    fun addHeader(headView: Int) {
        headerVisi = true
        useHead = true
        this.headView = headView
        data.add(data[0])
        notifyItemInserted(0)
    }

    fun addBody(bodyView: Int) {
        this.bodyView = bodyView
    }

    fun removeHeader() {
        useHead = false
        data.removeAt(0)
        notifyItemRemoved(0)
    }

    fun headerVisi(visibility: Boolean) {
        headerVisi = visibility
    }

    fun addFooter(footerView: Int) {
        footerVisi = true
        useFoot = true
        this.footerView = footerView
        data.add(data[data.size - 1])
        notifyItemInserted(data.size - 1)
    }

    fun removeFooter() {
        useFoot = false
        data.removeAt(data.size - 1)
        notifyItemRemoved(data.size - 1)
    }

    fun footerVisi(visibility: Boolean) {
        footerVisi = visibility
    }

    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int): Int {
        if (useHead && !useFoot) {
            return if (position == 0) HEADER else BODY
        } else if (!useHead && useFoot) {
            return if (position == data.size - 1) FOOTER else BODY
        } else if (useHead && useFoot) {
            if (position == 0) {
                return HEADER
            } else if (position == data.size - 1) {
                return FOOTER
            } else {
                return BODY
            }
        } else if (!useHead && !useFoot) {
            return BODY
        }else {
            return BODY
        }
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0) {
        } else {
            holder.itemView.tv_title_hot_body.text = data[position].tCn
            holder.itemView.tv_type_hot_body.text = data[position].movieType
            holder.itemView.tv_actor_hot_body.text = "导演： " + data[position].dN +
                    "\n" + "主演: " + data[position].aN1 + "\n" + data[position].actors
            holder.itemView.tv_date_hot_body.text = data[position].commonSpecial
            Glide.with(mContext)
                    .asBitmap()
                    .load(data[position].img)
                    .apply(RequestOptions()
                            .centerCrop()
//                            .override(100)
                            .placeholder(R.drawable.ic_no_video)
                            .error(R.drawable.ic_no_video)
                            .priority(Priority.HIGH)
                            .diskCacheStrategy(DiskCacheStrategy.NONE))
                    .into(holder.itemView.iv_hot_body)
            holder.itemView.cv_hot_body.setOnClickListener {
                onClick(holder.itemView, holder.adapterPosition)
            }
        }
    }

    class HeaderHolder(view: View) : RecyclerView.ViewHolder(view)

    class BodyHolder(view: View) : RecyclerView.ViewHolder(view)

    class FooterHolder(view: View) : RecyclerView.ViewHolder(view)

}