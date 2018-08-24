package com.kai.time.utils

import android.content.Context
import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import com.kai.time.App

val mContext = Common.context

fun findColor(@ColorRes resId: kotlin.Int): kotlin.Int {
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
        return ContextCompat.getColor(Common.context,resId)
    } else {
        return Common.context.getColor(resId)
    }
}

fun getDrawble(drawble: kotlin.Int): Drawable? {
    return if (Build.VERSION.SDK_INT >= 23) ContextCompat.getDrawable(Common.context, drawble) else getDrawble(drawble)
}


val dm = Common.context.resources.displayMetrics
fun getScreeHeight(): Int {

    return dm.heightPixels
}

fun getScreeWidth(): Int {
    return dm.widthPixels
}

val sp: SharedPreferences by lazy { App.instance.applicationContext.getSharedPreferences("meo", Context.MODE_PRIVATE) }

fun spSetString(key: kotlin.String, value: kotlin.String) = sp.edit().putString(key, value).apply()

fun getString(key: kotlin.String, defaultValue: kotlin.String) = sp.getString(key, defaultValue)

fun spSetInt(key: kotlin.String, value: kotlin.Int) = sp.edit().putInt(key, value).apply()

fun getInt(key: kotlin.String, defaultValue: kotlin.Int) = sp.getInt(key, defaultValue)

fun spSetBoolean(key: kotlin.String, value: kotlin.Boolean) = sp.edit().putBoolean(key, value).apply()

fun getBoolean(key: kotlin.String, defaultValue: kotlin.Boolean) = sp.getBoolean(key, defaultValue)

fun spSetFloat(key: kotlin.String, value: kotlin.Float) = sp.edit().putFloat(key, value).apply()

fun getFloat(key: kotlin.String, defaultValue: kotlin.Float) = sp.getFloat(key, defaultValue)

fun spSetLong(key: kotlin.String, value: kotlin.Long) = sp.edit().putLong(key, value).apply()

fun getLong(key: kotlin.String, defaultValue: kotlin.Long) = sp.getLong(key, defaultValue)