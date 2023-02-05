package com.pozdniakov.movieviewer.api

import com.pozdniakov.movieviewer.api.MovieApi

class MainRepository constructor(private val movieApi: MovieApi) {
    suspend fun getPopular() = movieApi.getPopular()
    suspend fun getDescription(id: Int) = movieApi.getDescription(id)
}