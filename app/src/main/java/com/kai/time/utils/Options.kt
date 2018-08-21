package com.kai.time.utils

import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.kai.time.R


var options = RequestOptions()
        .centerCrop()
        .placeholder(R.drawable.ic_fail_img)
        .error(R.drawable.ic_fail_img)
        .priority(Priority.HIGH)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
