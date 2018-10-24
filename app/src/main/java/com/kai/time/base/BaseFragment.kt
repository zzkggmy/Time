package com.kai.time.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.kai.time.R
import com.kai.time.utils.StatusBarUtil
import com.kai.time.utils.findColor
import com.kai.time.view.LoadingProgress
import com.kai.time.view.ToolBar

abstract class BaseFragment : Fragment() {

    private lateinit var linearLayout: LinearLayout
    private lateinit var loadingProgress: LoadingProgress
    private lateinit var toolBar: ToolBar
    private lateinit var activity: Context
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, bindLayout(), null)
        toolBar = ToolBar(activity)
        loadingProgress = LoadingProgress(activity)
        linearLayout = LinearLayout(activity)
        val params: ViewGroup.LayoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        toolBar.fitsSystemWindows = true
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.addView(toolBar, params)
        initView(view)
        StatusBarUtil.setColor(toolBar, getActivity()!!, findColor(R.color.zhihu_primary))
        setLeftImage(R.drawable.ic_back, 30, 30)
        return view
    }

    override fun onStart() {
        super.onStart()
    }

    protected abstract fun initWidget(view: View)

    abstract fun initView(view: View)

    protected abstract fun bindLayout(): Int


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