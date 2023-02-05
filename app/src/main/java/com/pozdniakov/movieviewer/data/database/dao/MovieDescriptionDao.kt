package com.pozdniakov.movieviewer.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pozdniakov.movieviewer.data.database.entity.MovieDescriptionEntity

@Dao
interface MovieDescriptionDao {
    @Query("SELECT * FROM movie_description")
    fun getAll(): LiveData<List<MovieDescriptionEntity>>

    @Query("SELECT * FROM movie_description WHERE filmId=:id")
    fun getById(id: Long): LiveData<MovieDescriptionEntity>

    @Insert
    fun insert(description: MovieDescriptionEntity?)

    @Update
    fun update(description: MovieDescriptionEntity?)

    @Delete
    fun delete(description: MovieDescriptionEntity?)
}