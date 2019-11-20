package com.example.moviesqueezer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.moviesqueezer.R
import com.example.moviesqueezer.model.Movie

class DetailsActivity : AppCompatActivity() {

    private lateinit var movieDetail: Movie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        movieDetail = intent.getSerializableExtra("movieDetails") as Movie
        Log.e("Details Activity", "Movie Name"+movieDetail.title)
    }
}
