package com.kai.time.utils

import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.kai.time.R


var options = RequestOptions()
        .centerCrop()
        .override(getScreeWidth(), 200)
        .placeholder(R.drawable.ic_no_video)
        .error(R.drawable.ic_no_video)
        .priority(Priority.HIGH)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
