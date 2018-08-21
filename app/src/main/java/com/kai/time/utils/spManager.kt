package com.kai.time.utils

import com.kai.time.R


fun setToken(token: String) {
    spSetString("token", token)
}

val getToken = getString("token","")

fun setThemeColor(color: Int) {
    spSetInt("color", color)
}

val getThemeColor = getInt("color", R.color.zhihu_primary)