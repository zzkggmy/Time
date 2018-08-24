package com.kai.time.bean

data class MovieDetailsBean(var code: String,
                            var data: Data,
                            var msg: String,
                            var showMsg: String) {
    data class Data(var advertisement: Advertisement,
                    var basic: Basic,
                    var boxOffice: BoxOffice,
                    var live: Live,
                    var playState: String,
                    var related: Related,
                    var playlist: List<Playlist>) {
        data class Advertisement(var count: Int,
                                 var error: String,
                                 var success: Boolean,
                                 var advList: List<AdvList>) {
            data class AdvList(var advTag: String,
                               var endDate: Int,
                               var isHorizontalScreen: Boolean,
                               var isOpenH5: Boolean,
                               var startDate: Int,
                               var tag: String,
                               var `type`: String,
                               var typeName: String,
                               var url: String)
        }

        data class Basic(var award: Award,
                         var bigImage: String,
                         var commentSpecial: String,
                         var community: Community,
                         var director: Director,
                         var hotRanking: Int,
                         var img: String,
                         var is3D: Boolean,
                         var isDMAX: Boolean,
                         var isEggHunt: Boolean,
                         var isFilter: Boolean,
                         var isIMAX: Boolean,
                         var isIMAX3D: Boolean,
                         var isTicket: Boolean,
                         var message: String,
                         var mins: String,
                         var movieId: Int,
                         var movieStatus: Int,
                         var name: String,
                         var nameEn: String,
                         var overallRating: Double,
                         var personCount: Int,
                         var quizGame: QuizGame,
                         var releaseArea: String,
                         var releaseDate: String,
                         var sensitiveStatus: Boolean,
                         var showCinemaCount: Int,
                         var showDay: Int,
                         var showtimeCount: Int,
                         var stageImg: StageImg,
                         var story: String,
                         var style: Style,
                         var totalNominateAward: Int,
                         var totalWinAward: Int,
                         var url: String,
                         var video: Video,
                         var actors: List<Actors>,
                         var festivals: List<Any>,
                         var `type`: List<String>) {
            data class Award(var totalNominateAward: Int,
                             var totalWinAward: Int,
                             var awardList: List<Any>)

            data class Community(var id: Int)
            data class Director(var directorId: Int,
                                var img: String,
                                var name: String,
                                var nameEn: String)

            data class QuizGame(var id: Int)
            data class StageImg(var count: Int,
                                var list: List<ImgList>) {
                data class ImgList(var imgId: Int,
                                var imgUrl: String)
            }

            data class Style(var isLeadPage: Int,
                             var leadImg: String,
                             var leadUrl: String)

            data class Video(var count: Int,
                             var hightUrl: String,
                             var img: String,
                             var title: String,
                             var url: String,
                             var videoId: Int,
                             var videoSourceType: Int)

            data class Actors(var actorId: Int,
                              var img: String,
                              var name: String,
                              var nameEn: String,
                              var roleImg: String,
                              var roleName: String)
        }

        data class BoxOffice(var movieId: Int,
                             var ranking: Int,
                             var todayBox: Int,
                             var todayBoxDes: String,
                             var todayBoxDesUnit: String,
                             var totalBox: Long,
                             var totalBoxDes: String,
                             var totalBoxUnit: String)

        data class Live(var count: Int,
                        var img: String,
                        var liveId: Int,
                        var playNumTag: String,
                        var playTag: String,
                        var status: Int,
                        var title: String)

        data class Related(var goodsCount: Int,
                           var relateId: Int,
                           var relatedUrl: String,
                           var `type`: Int,
                           var goodsList: List<Any>)

        data class Playlist(var isOpenByBrowser: Boolean,
                            var payRule: String,
                            var picUrl: String,
                            var playSourceName: String,
                            var playUrl: String,
                            var sourceId: String)
    }
}