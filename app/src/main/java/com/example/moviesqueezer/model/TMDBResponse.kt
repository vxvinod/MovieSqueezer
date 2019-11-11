package com.example.moviesqueezer.model

import com.google.gson.annotations.SerializedName

class TMDBResponse {

    @SerializedName("page")
    var page: Int? = null;
    @SerializedName("results")
    var results = ArrayList<Movie>()
    @SerializedName("total_results")
    var totalResults: Int? = null
    @SerializedName("total_pages")
    var totalPages: Int? = null

}