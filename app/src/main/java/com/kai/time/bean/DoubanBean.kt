package com.kai.time.bean

data class DoubanBean(var count: Int,
                      var start: Int,
                      var total: Int,
                      var title: String,
                      var subjects: List<Subjects>) {
    data class Subjects(var rating: Rating,
                        var title: String,
                        var collect_count: Int,
                        var mainland_pubdate: String,
                        var has_video: Boolean,
                        var original_title: String,
                        var subtype: String,
                        var year: String,
                        var images: Images,
                        var alt: String,
                        var id: String,
                        var genres: List<String>,
                        var casts: List<Casts>,
                        var durations: List<String>,
                        var directors: List<Directors>,
                        var pubdates: List<String>) {
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

        data class Casts(var avatars: Avatars,
                         var name_en: String,
                         var name: String,
                         var alt: String,
                         var id: String) {
            data class Avatars(var small: String,
                               var large: String,
                               var medium: String)
        }

        data class Directors(var avatars: Avatars,
                             var name_en: String,
                             var name: String,
                             var alt: String,
                             var id: String) {
            data class Avatars(var small: String,
                               var large: String,
                               var medium: String)
        }
    }
}