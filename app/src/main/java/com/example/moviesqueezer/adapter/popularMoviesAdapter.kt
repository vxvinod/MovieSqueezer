package com.example.moviesqueezer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesqueezer.R
import com.example.moviesqueezer.model.Movie
import com.example.moviesqueezer.ui.MainActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*

class PopularMoviesAdapter( private val context: MainActivity, val movieList: List<Movie>) : RecyclerView.Adapter<PopularMoviesAdapter.MovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesAdapter.MovieHolder {
        return MovieHolder(LayoutInflater.from(context).inflate(R.layout.rv_movie_list, parent, false))
    }

    override fun getItemCount(): Int {
        //return 10
        return movieList.size
    }

    override fun onBindViewHolder(holder: PopularMoviesAdapter.MovieHolder, position: Int) {
        if(movieList != null) {
            Picasso.get().load("http://image.tmdb.org/t/p/w185//" + movieList[position].posterPath)
                .into(holder.imageView)
        }
    }

    class MovieHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView? = view.findViewById(R.id.poster_image_view)
    }


}



