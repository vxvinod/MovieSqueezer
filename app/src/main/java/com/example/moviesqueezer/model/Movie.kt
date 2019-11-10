package com.example.moviesqueezer.model

import com.google.gson.annotations.SerializedName
import java.util.*

class Movie {
    @SerializedName("id")
    var id: Int? = null
    @SerializedName("original_title")
    var originalTitle: String? = null
    @SerializedName("overview")
    var overview: String? = null
    @SerializedName("poster_path")
    var posterPath: String? = null
    @SerializedName("release_date")
    var release_date: String? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("vote_average")
    var rating: String? = null
    @SerializedName("vote_count")
    var voteCount: String? = null
    @SerializedName("backdrop_path")
    var backdropPath: String? = null
}