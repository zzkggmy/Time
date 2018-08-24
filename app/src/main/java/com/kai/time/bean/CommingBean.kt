package com.kai.time.bean

data class CommingBean(var attention: List<Attention>,
                       var moviecomings: List<Moviecomings>) {
    data class Attention(var actor1: String,
                         var actor2: String,
                         var director: String,
                         var id: Int,
                         var image: String,
                         var isFilter: Boolean,
                         var isTicket: Boolean,
                         var isVideo: Boolean,
                         var locationName: String,
                         var rDay: Int,
                         var rMonth: Int,
                         var rYear: Int,
                         var releaseDate: String,
                         var title: String,
                         var `type`: String,
                         var videoCount: Int,
                         var wantedCount: Int,
                         var videos: List<Videos>) {
        data class Videos(var hightUrl: String,
                          var image: String,
                          var length: Int,
                          var title: String,
                          var url: String,
                          var videoId: Int)
    }

    data class Moviecomings(var actor1: String,
                            var actor2: String,
                            var director: String,
                            var id: Int,
                            var image: String,
                            var isFilter: Boolean,
                            var isTicket: Boolean,
                            var isVideo: Boolean,
                            var locationName: String,
                            var rDay: Int,
                            var rMonth: Int,
                            var rYear: Int,
                            var releaseDate: String,
                            var title: String,
                            var `type`: String,
                            var videoCount: Int,
                            var wantedCount: Int,
                            var videos: List<Videos>) {
        data class Videos(var hightUrl: String,
                          var image: String,
                          var length: Int,
                          var title: String,
                          var url: String,
                          var videoId: Int)
    }
}