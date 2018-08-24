package com.kai.time.bean

data class DoubanDetailsBean(var rating: Rating,
                             var reviews_count: Int,
                             var wish_count: Int,
                             var original_title: String,
                             var collect_count: Int,
                             var images: Images,
                             var douban_site: String,
                             var year: String,
                             var alt: String,
                             var id: String,
                             var mobile_url: String,
                             var photos_count: Int,
                             var pubdate: String,
                             var title: String,
                             var do_count: Any,
                             var has_video: Boolean,
                             var share_url: String,
                             var seasons_count: Any,
                             var schedule_url: String,
                             var website: String,
                             var has_schedule: Boolean,
                             var collection: Any,
                             var episodes_count: Any,
                             var has_ticket: Boolean,
                             var current_season: Any,
                             var mainland_pubdate: String,
                             var summary: String,
                             var subtype: String,
                             var comments_count: Int,
                             var ratings_count: Int,
                             var videos: List<Videos>,
                             var blooper_urls: List<Any>,
                             var popular_comments: List<PopularComments>,
                             var languages: List<String>,
                             var writers: List<Writers>,
                             var pubdates: List<String>,
                             var tags: List<String>,
                             var durations: List<String>,
                             var genres: List<String>,
                             var trailers: List<Trailers>,
                             var trailer_urls: List<String>,
                             var bloopers: List<Any>,
                             var clip_urls: List<Any>,
                             var casts: List<Casts>,
                             var countries: List<String>,
                             var photos: List<Photos>,
                             var clips: List<Any>,
                             var directors: List<Directors>,
                             var popular_reviews: List<PopularReviews>,
                             var aka: List<String>) {
    data class Rating(var max: Int,
                      var average: Double,
                      var details: Details,
                      var stars: String,
                      var min: Int) {
        data class Details(var one: Int,
                           var two: Int,
                           var three: Int,
                           var four: Int,
                           var five: Int)
    }

    data class Images(var small: String,
                      var large: String,
                      var medium: String)

    data class Videos(var source: Source,
                      var sample_link: String,
                      var video_id: String,
                      var need_pay: Boolean) {
        data class Source(var literal: String,
                          var pic: String,
                          var name: String)
    }

    data class PopularComments(var rating: Rating,
                               var useful_count: Int,
                               var author: Author,
                               var subject_id: String,
                               var content: String,
                               var created_at: String,
                               var id: String) {
        data class Rating(var max: Int,
                          var value: Int,
                          var min: Int)

        data class Author(var uid: String,
                          var avatar: String,
                          var signature: String,
                          var alt: String,
                          var id: String,
                          var name: String)
    }

    data class Writers(var avatars: Avatars,
                       var name_en: String,
                       var name: String,
                       var alt: String,
                       var id: String) {
        data class Avatars(var small: String,
                           var large: String,
                           var medium: String)
    }

    data class Trailers(var medium: String,
                        var title: String,
                        var subject_id: String,
                        var alt: String,
                        var small: String,
                        var resource_url: String,
                        var id: String)

    data class Casts(var avatars: Avatars,
                     var name_en: String,
                     var name: String,
                     var alt: String,
                     var id: String) {
        data class Avatars(var small: String,
                           var large: String,
                           var medium: String)
    }

    data class Photos(var thumb: String,
                      var image: String,
                      var cover: String,
                      var alt: String,
                      var id: String,
                      var icon: String)

    data class Directors(var avatars: Avatars,
                         var name_en: String,
                         var name: String,
                         var alt: String,
                         var id: String) {
        data class Avatars(var small: String,
                           var large: String,
                           var medium: String)
    }

    data class PopularReviews(var rating: Rating,
                              var title: String,
                              var subject_id: String,
                              var author: Author,
                              var summary: String,
                              var alt: String,
                              var id: String) {
        data class Rating(var max: Int,
                          var value: Int,
                          var min: Int)

        data class Author(var uid: String,
                          var avatar: String,
                          var signature: String,
                          var alt: String,
                          var id: String,
                          var name: String)
    }
}