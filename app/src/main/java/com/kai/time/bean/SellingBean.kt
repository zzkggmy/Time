package com.kai.time.bean

data class SellingBean(var count: Int,
                       var totalCinemaCount: Int,
                       var totalComingMovie: Int,
                       var totalHotMovie: Int,
                       var movies: List<Movies>) {
    data class Movies(var actorName1: String,
                      var actorName2: String,
                      var btnText: String,
                      var commonSpecial: String,
                      var directorName: String,
                      var img: String,
                      var is3D: Boolean,
                      var isDMAX: Boolean,
                      var isFilter: Boolean,
                      var isHot: Boolean,
                      var isIMAX: Boolean,
                      var isIMAX3D: Boolean,
                      var isNew: Boolean,
                      var length: Int,
                      var movieId: Int,
                      var nearestShowtime: NearestShowtime,
                      var preferentialFlag: Boolean,
                      var rDay: Int,
                      var rMonth: Int,
                      var rYear: Int,
                      var ratingFinal: Double,
                      var titleCn: String,
                      var titleEn: String,
                      var `type`: String,
                      var wantedCount: Int) {
        data class NearestShowtime(var isTicket: Boolean,
                                   var nearestCinemaCount: Int,
                                   var nearestShowDay: Int,
                                   var nearestShowtimeCount: Int)
    }
}