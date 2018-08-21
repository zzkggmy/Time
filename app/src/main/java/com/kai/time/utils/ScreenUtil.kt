package com.kai.time.utils


object ScreenUtil {

    val dm = mContext.resources.displayMetrics
    fun getScreeHeight(): Int {

        return dm.heightPixels
    }

    fun getScreeWidth(): Int {
        return dm.widthPixels
    }

}