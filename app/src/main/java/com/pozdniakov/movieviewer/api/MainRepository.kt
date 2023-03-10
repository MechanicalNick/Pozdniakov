package com.pozdniakov.movieviewer.api

class MainRepository constructor(private val movieApi: MovieApi) {
    suspend fun getPopular() = movieApi.getPopular()
    suspend fun getDescription(id: Int) = movieApi.getDescription(id)
}