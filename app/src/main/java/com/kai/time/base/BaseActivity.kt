package com.kai.time.base

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.kai.time.R
import com.kai.time.utils.StatusBarUtil
import com.kai.time.utils.findColor
import com.kai.time.view.LoadingProgress
import com.kai.time.view.ToolBar


abstract class BaseActivity : AppCompatActivity() {



    private lateinit var linearLayout: LinearLayout
    private lateinit var loadingProgress: LoadingProgress
    private lateinit var toolBar: ToolBar

    @RequiresApi(Build.VERSION_CODES.M)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolBar = ToolBar(this)
        loadingProgress = LoadingProgress(this)
        linearLayout = LinearLayout(this)
        val params: ViewGroup.LayoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        toolBar.fitsSystemWindows = true
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.addView(toolBar, params)
        setContentView(bindLayout())
        StatusBarUtil.setColor(toolBar,this, findColor(R.color.zhihu_primary))
        setLeftImage(R.drawable.ic_back,30,30)
        setTitleBarLeftClick { finish() }
        initView()
    }


    abstract fun bindLayout(): Int


    abstract fun initView()

    protected open fun useTitleBar(): Boolean = true

    override fun setContentView(view: View?) = if (useTitleBar()) {
        linearLayout.addView(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        super.setContentView(linearLayout)
    } else {
        super.setContentView(view)
    }

    override fun setContentView(layoutResID: Int) = if (useTitleBar()) {
        val view = layoutInflater.inflate(layoutResID, linearLayout, false)
        linearLayout.addView(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        super.setContentView(linearLayout)
    } else {
        super.setContentView(layoutResID)
    }

    override fun setContentView(view: View?, params: ViewGroup.LayoutParams?) = if (useTitleBar()) {
        linearLayout.addView(view, params)
        super.setContentView(linearLayout)
    } else {
        super.setContentView(view, params)
    }

    fun setTitleBarBackgroundColor(themeColor: Int) = toolBar.setBackgroundColor(themeColor)

    fun setLeftText(text: String, textSize: Float, textColor: Int) = toolBar.setLeftText(text, textSize, textColor)
    fun setLeftImage(drawable: Int, imgWidth: Int, imgHeight: Int) = toolBar.setLeftImage(drawable, imgWidth, imgHeight)


    fun setCenterText(text: String, textSize: Float, textColor: Int) = toolBar.setCenterText(text, textSize, textColor)
    fun setCenterImage(drawable: Int, imgWidth: Int, imgHeight: Int) = toolBar.setCenterImage(drawable, imgWidth, imgHeight)

    fun setRightText(text: String, textSize: Float, textColor: Int) = toolBar.setRightText(text, textSize, textColor)
    fun setRightImage(drawable: Int, imgWidth: Int, imgHeight: Int) = toolBar.setRightImage(drawable, imgWidth, imgHeight)


    protected fun setTitleBarLeftClick(func: () -> Unit) = toolBar.setTitleLeftClick(func)
    protected fun setTitleCenterClick(func: () -> Unit) = toolBar.setTitleCenterClick(func)
    protected fun setTitleRightClick(func: () -> Unit) = toolBar.setTitleRightClick(func)

    fun showLoading() {
        loadingProgress.showLoding()
    }

    fun dismissLoading() {
        loadingProgress.dismissLoding()
    }

    protected fun userTitleBar() = true


    private fun getStatusBarHeight(): Int {
        var statusBarHeight = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            statusBarHeight = resources.getDimensionPixelSize(resourceId)
        }
        return statusBarHeight
    }
}