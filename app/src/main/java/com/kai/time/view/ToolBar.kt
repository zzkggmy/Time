package com.kai.time.view

import android.content.Context
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.kai.time.utils.findColor
import com.kai.time.utils.getThemeColor

class ToolBar(context: Context) : Toolbar(context) {
    private var relativeLayout: RelativeLayout
    private var leftLinearLayout: LinearLayout
    private var centerLinearLayout: LinearLayout
    private var rightLinearLayout: LinearLayout

    init {
        setBackgroundColor(findColor(getThemeColor))
        relativeLayout = RelativeLayout(context)
        leftLinearLayout = LinearLayout(context)
        centerLinearLayout = LinearLayout(context)
        rightLinearLayout = LinearLayout(context)
        val params = Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.WRAP_CONTENT)
        params.setMargins(0, 0, 0, 0)
        val leftParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        leftParams.setMargins(10, 0, 10, 0)
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_START)
        leftParams.addRule(RelativeLayout.CENTER_VERTICAL)
        relativeLayout.addView(leftLinearLayout, leftParams)
        val centerParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        centerParams.setMargins(0, 0, 0, 0)
        centerParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        relativeLayout.addView(centerLinearLayout, centerParams)
        val righttParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        righttParams.setMargins(10, 0, 10, 0)
        righttParams.addRule(RelativeLayout.ALIGN_PARENT_END)
        righttParams.addRule(RelativeLayout.CENTER_VERTICAL)
        relativeLayout.addView(rightLinearLayout, righttParams)
        addView(relativeLayout, params)
    }

    fun setLeftText(text: String,textSize: Float, textColor: Int) {
        val tv = TextView(context)
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.setMargins(0, 0, 0, 0)
        leftLinearLayout.addView(tv, params)
        tv.text = text
        tv.textSize = textSize
        tv.setTextColor(findColor(textColor))
    }

    fun setLeftImage(drawable: Int, imgWidth: Int, imgHeight: Int) {
        val iv = ImageView(context)
        val params = LinearLayout.LayoutParams(imgWidth, imgHeight)
        params.setMargins(0, 0, 0, 0)
        leftLinearLayout.addView(iv, params)
        iv.setBackgroundResource(drawable)
    }

    fun setCenterText(text: String, textSize: Float, textColor: Int) {
        val tv = TextView(context)
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.setMargins(0, 0, 0, 0)
        params.gravity = Gravity.CENTER
        centerLinearLayout.addView(tv, params)
        tv.text = text
        tv.textSize = textSize
        tv.setTextColor(findColor(textColor))
    }

    fun setCenterImage(drawable: Int, imgWidth: Int, imgHeight: Int) {
        val iv = ImageView(context)
        val params = LinearLayout.LayoutParams(imgWidth, imgHeight)
        params.setMargins(0, 0, 0, 0)
        params.gravity = Gravity.CENTER
        centerLinearLayout.addView(iv, params)
        iv.setBackgroundResource(drawable)
    }

    fun setRightText(text: String, textSize: Float, textColor: Int) {
        val tv = TextView(context)
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.setMargins(0, 0, 0, 0)
        params.gravity = Gravity.CENTER
        rightLinearLayout.addView(tv, params)
        tv.text = text
        tv.textSize = textSize
        tv.setTextColor(findColor(textColor))
    }

    fun setRightImage(drawable: Int, imgWidth: Int, imgHeight: Int) {
        val iv = ImageView(context)
        val params = LinearLayout.LayoutParams(imgWidth, imgHeight)
        params.setMargins(0, 0, 0, 0)
        params.gravity = Gravity.CENTER
        rightLinearLayout.addView(iv, params)
        iv.setBackgroundResource(drawable)
    }

    fun setTitleLeftClick(func: (() -> Unit)?) = leftLinearLayout.setOnClickListener { func?.invoke() }
    fun setTitleCenterClick(func: (() -> Unit)?) = centerLinearLayout.setOnClickListener { func?.invoke() }
    fun setTitleRightClick(func: (() -> Unit)?) = rightLinearLayout.setOnClickListener { func?.invoke() }

}