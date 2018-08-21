package com.kai.time.bean

data class HomeBean(var count: Int,
                    var total: Int,
                    var nextPageUrl: String,
                    var adExist: Boolean,
                    var date: Long,
                    var nextPublishTime: Long,
                    var dialog: Any,
                    var topIssue: Any,
                    var refreshCount: Int,
                    var lastStartId: Int,
                    var itemList: List<ItemList>) {
    data class ItemList(var `type`: String,
                        var data: Data,
                        var tag: String,
                        var id: Int,
                        var adIndex: Int) {
        data class Data(var dataType: String,
                        var id: Int,
                        var title: String,
                        var description: String,
                        var library: String,
                        var consumption: Consumption,
                        var resourceType: String,
                        var slogan: String,
                        var provider: Provider,
                        var category: String,
                        var author: Author,
                        var cover: Cover,
                        var playUrl: String,
                        var thumbPlayUrl: Any,
                        var duration: Int,
                        var webUrl: WebUrl,
                        var releaseTime: Long,
                        var campaign: Any,
                        var waterMarks: Any,
                        var adTrack: Any,
                        var `type`: String,
                        var titlePgc: Any,
                        var descriptionPgc: Any,
                        var remark: Any,
                        var ifLimitVideo: Boolean,
                        var searchWeight: Int,
                        var idx: Int,
                        var shareAdTrack: Any,
                        var favoriteAdTrack: Any,
                        var webAdTrack: Any,
                        var date: Long,
                        var promotion: Any,
                        var label: Any,
                        var descriptionEditor: String,
                        var collected: Boolean,
                        var played: Boolean,
                        var lastViewTime: Any,
                        var playlists: Any,
                        var src: Any,
                        var tags: List<Tags>,
                        var playInfo: List<PlayInfo>,
                        var labelList: List<Any>,
                        var subtitles: List<Any>) {
            data class Consumption(var collectionCount: Int,
                                   var shareCount: Int,
                                   var replyCount: Int)

            data class Provider(var name: String,
                                var alias: String,
                                var icon: String)

            data class Author(var id: Int,
                              var icon: String,
                              var name: String,
                              var description: String,
                              var link: String,
                              var latestReleaseTime: Long,
                              var videoNum: Int,
                              var adTrack: Any,
                              var follow: Follow,
                              var shield: Shield,
                              var approvedNotReadyVideoCount: Int,
                              var ifPgc: Boolean) {
                data class Follow(var itemType: String,
                                  var itemId: Int,
                                  var followed: Boolean)

                data class Shield(var itemType: String,
                                  var itemId: Int,
                                  var shielded: Boolean)
            }

            data class Cover(var feed: String,
                             var detail: String,
                             var blurred: String,
                             var sharing: Any,
                             var homepage: String)

            data class WebUrl(var raw: String,
                              var forWeibo: String)

            data class Tags(var id: Int,
                            var name: String,
                            var actionUrl: String,
                            var adTrack: Any,
                            var desc: Any,
                            var bgPicture: String,
                            var headerImage: String,
                            var tagRecType: String,
                            var childTagList: Any,
                            var childTagIdList: Any)

            data class PlayInfo(var height: Int,
                                var width: Int,
                                var name: String,
                                var `type`: String,
                                var url: String,
                                var urlList: List<UrlList>) {
                data class UrlList(var name: String,
                                   var url: String,
                                   var size: Int)
            }
        }
    }
}