package com.example.moviesqueezer.model

import com.google.gson.annotations.SerializedName
import java.util.*

class Movie {
    constructor(
        id: Int?,
        originalTitle: String?,
        overview: String?,
        posterPath: String?,
        release_date: String?,
        title: String?,
        rating: String?,
        voteCount: String?,
        backdropPath: String?
    ) {
        this.id = id
        this.originalTitle = originalTitle
        this.overview = overview
        this.posterPath = posterPath
        this.release_date = release_date
        this.title = title
        this.rating = rating
        this.voteCount = voteCount
        this.backdropPath = backdropPath
    }

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