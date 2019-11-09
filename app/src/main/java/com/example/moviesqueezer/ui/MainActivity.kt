package com.example.moviesqueezer.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.example.moviesqueezer.R
import com.example.moviesqueezer.model.TMDBResponse
import com.example.moviesqueezer.networkService.TMBDService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_home)
                getTMBDdata()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                textMessage.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    internal fun getTMBDdata() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(TMBDService::class.java)
        val call = service.getMovieData(type, apiKey)
        call.enqueue(object : Callback<TMDBResponse> {
            override fun onResponse(call: Call<TMDBResponse>, response: Response<TMDBResponse>) {

                if(response.code() == 200){
                    val movieResponse = response.body()
                    val stringBuilder = "Movie Pages" + movieResponse?.totalPages+
                                        "total Results" + movieResponse?.totalResults
                    textMessage!!.text = stringBuilder

                }
            }

            override fun onFailure(call: Call<TMDBResponse>, t: Throwable) {
               
                textMessage!!.text = t.message
            }
        })
    }

    companion object {
        var BaseUrl = "https://api.themoviedb.org/3/"
        var type = "popular"
        var apiKey = "1f6edcf7cdec1a1942d5d87e84a1ab89"
    }
}



