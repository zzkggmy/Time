package com.kai.time.utils

import android.app.Application

object Common {
    lateinit var context: Application
    fun with(application: Application) {
        this.context = application
    }
}