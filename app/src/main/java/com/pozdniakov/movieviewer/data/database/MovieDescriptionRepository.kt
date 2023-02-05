package com.pozdniakov.movieviewer.data.database

import androidx.lifecycle.LiveData
import com.pozdniakov.movieviewer.data.database.dao.MovieDescriptionDao
import com.pozdniakov.movieviewer.data.database.entity.MovieDescriptionEntity

class MovieDescriptionRepository(private val movieDescriptionDao: MovieDescriptionDao) {
    fun getAll(): LiveData<List<MovieDescriptionEntity>> = movieDescriptionDao.getAll()
    suspend fun getById(id: Long) = movieDescriptionDao.getById(id)
    suspend fun insert(description: MovieDescriptionEntity) = movieDescriptionDao.insert(description)
}