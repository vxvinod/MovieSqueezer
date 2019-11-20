package com.example.moviesqueezer.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesqueezer.R
import com.example.moviesqueezer.adapter.OnItemClickListener
import com.example.moviesqueezer.adapter.PopularMoviesAdapter
import com.example.moviesqueezer.adapter.addOnItemClickListener
import com.example.moviesqueezer.model.Movie
import com.example.moviesqueezer.model.TMDBResponse
import com.example.moviesqueezer.networkService.TMBDService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    private var movieList: ArrayList<Movie> = ArrayList<Movie>()
    private lateinit var  movieRv: RecyclerView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                Log.e("MAIN ACT", "INSIDE NAV HOME")
                getTMBDdata("popular")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                Log.e("MAIN ACT", "INSIDE NAV DASHBOARD")

                getTMBDdata("top_rated")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        movieRv = findViewById(R.id.rv_movies)

        movieRv.layoutManager = GridLayoutManager(this, 2)
        movieRv.adapter = PopularMoviesAdapter(this, movieList)
        getTMBDdata("popular")
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        movieRv.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {

                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtra("movieDetails", movieList[position])
                Log.e("Main Activity", "Name"+movieList[position].title)
                startActivity(intent)
            }
        })
   }

    internal fun getTMBDdata(type: String) {
        Log.e("MAIN ACT", "INSIDE getTMBDData")
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(TMBDService::class.java)
        val call = service.getMovieData(type, apiKey)
        call.enqueue(object : Callback<TMDBResponse> {

            override fun onResponse(call: Call<TMDBResponse>, response: Response<TMDBResponse>) {
               Log.e("MAIN ACT", "INSIDE ONRESPONSE")
                movieList.clear()
                if(response.code() == 200){
                    val movieResponse = response.body()
                    val stringBuilder = "Movie Pages" + movieResponse?.totalPages+
                                        "total Results" + movieResponse?.results
                    movieResponse?.results?.let { movieList.addAll(it) }
                    movieRv.adapter?.notifyDataSetChanged()
                    for(movi in movieList){

                        Log.e("MAIN ACT", movi.title.toString())
                    }


                    //textMessage!!.text = stringBuilder


                }
            }

            override fun onFailure(call: Call<TMDBResponse>, t: Throwable) {


            }
        })
    }


    companion object {
        var BaseUrl = "https://api.themoviedb.org/3/"
        var type = "popular"
        var apiKey = "1f6edcf7cdec1a1942d5d87e84a1ab89"
    }
}





