package com.kai.time

import android.app.Application
import com.kai.time.utils.Common

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Common.with(this)
    }
}