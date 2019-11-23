package com.example.moviesqueezer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import butterknife.BindView
import com.example.moviesqueezer.R
import com.example.moviesqueezer.databinding.ActivityDetailsBinding
import com.example.moviesqueezer.model.Movie
import org.w3c.dom.Text

class DetailsActivity : AppCompatActivity() {

    private lateinit var movieDetail: Movie
    @BindView(R.id.title_tv)
    lateinit var title: TextView
    @BindView(R.id.desc_tv)
    lateinit var overview: TextView
    @BindView(R.id.rating_value_tv)
    lateinit var rating: TextView
    @BindView(R.id.date_value_tv)
    lateinit var releaseDate: TextView
    @BindView(R.id.votes_value_tv)
    lateinit var voteCount: TextView
    @BindView(R.id.backdrop_iv)
    lateinit var backdropImg: ImageView
    @BindView(R.id.poster_image_view)
    lateinit var posterImg: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_details)
        movieDetail = intent.getSerializableExtra("movieDetails") as Movie
        val binding: ActivityDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        binding.movieData = movieDetail
        //Log.e("Details Activity", "Movie Name"+movieDetail.title)
        setMovieData(movieDetail)
    }

    fun setMovieData(movieData: Movie){

    }
}
