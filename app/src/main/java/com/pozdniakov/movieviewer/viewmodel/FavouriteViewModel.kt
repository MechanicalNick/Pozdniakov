package com.pozdniakov.movieviewer.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import com.pozdniakov.movieviewer.data.database.MovieDescriptionDatabase
import com.pozdniakov.movieviewer.data.database.MovieDescriptionRepository
import com.pozdniakov.movieviewer.data.database.entity.MovieDescriptionEntity

class FavouriteViewModel(private val app: Application) : BaseViewModel(), IInsertViewModel {

    private val movieDescriptionRepository: MovieDescriptionRepository
    val allData: LiveData<List<MovieDescriptionEntity>>

    init {
        val db = MovieDescriptionDatabase.getDataBase(app)
        movieDescriptionRepository = MovieDescriptionRepository(db.movieDescriptionDao())
        allData = movieDescriptionRepository.getAll()
    }

    override fun insert(toEntity: MovieDescriptionEntity) {
        // EMPTY
    }
}