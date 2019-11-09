package com.example.moviesqueezer.networkService

import com.example.moviesqueezer.model.TMDBResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

public interface TMBDService {

    @GET("movie/{type}")
    fun getMovieData(@Path("type") type: String, @Query("api_key") apiKey: String): Call<TMDBResponse>
}