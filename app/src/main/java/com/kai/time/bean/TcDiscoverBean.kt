package com.kai.time.bean

data class TcDiscoverBean(var result: String,
                          var banners: List<Banners>,
                          var hotEvents: List<HotEvents>,
                          var categories: List<Categories>) {
    data class Banners(var url: String,
                       var src: String)

    data class HotEvents(var tag_id: String,
                         var tag_name: String,
                         var created_at: String,
                         var status: String,
                         var posts: String,
                         var new_posts: String,
                         var participants: String,
                         var end_at: String,
                         var title: String,
                         var url: String,
                         var event_type: String,
                         var image_count: Int,
                         var deadline: String,
                         var prize_desc: String,
                         var prize_url: String,
                         var introduction_url: String,
                         var introduction_id: Int,
                         var competition_type: Int,
                         var remainingDays: Int,
                         var dueDays: Int,
                         var list_banner: Boolean,
                         var app_url: String,
                         var category: List<Any>,
                         var image_posts: List<Any>,
                         var images: List<String>)

    data class Categories(var tag_name: String,
                          var tag_id: Int)
}