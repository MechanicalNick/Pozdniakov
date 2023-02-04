package com.pozdniakov.movieviewer.api

import com.pozdniakov.movieviewer.Popular
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface MovieApi {
    @Headers(
        "X-API-KEY: e30ffed0-76ab-4dd6-b41f-4c9da2b2735b",
        "Content-Type: application/json"
    )
    @GET("/api/v2.2/films/top?type=TOP_100_POPULAR_FILMS")
    suspend fun getPopular() : Response<Popular>

    companion object {
        private const val baseUrl = "https://kinopoiskapiunofficial.tech"

        var retrofitService: MovieApi? = null

        fun getInstance() : MovieApi {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(MovieApi::class.java)
            }
            return retrofitService!!
        }

    }
}