package com.kai.time.activity

import android.content.Intent
import android.os.Handler
import com.kai.time.R
import com.kai.time.base.BaseActivity
import com.kai.time.utils.StatusBarUtil

class SplashActivity : BaseActivity() {
    override fun initView() {
        StatusBarUtil.setTranslucent(this, 0)
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)
    }


    override fun bindLayout() = R.layout.activity_splash

    override fun useTitleBar() = false
}