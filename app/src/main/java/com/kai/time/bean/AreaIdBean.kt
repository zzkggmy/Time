package com.kai.time.bean

data class AreaIdBean(var p: List<P>) {
    data class P(var count: Int,
                 var id: Int,
                 var n: String,
                 var pinyinFull: String,
                 var pinyinShort: String)
}