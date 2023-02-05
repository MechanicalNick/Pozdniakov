package com.pozdniakov.movieviewer.viewmodel

import com.pozdniakov.movieviewer.data.database.entity.MovieDescriptionEntity

interface IInsertViewModel {
    fun insert(toEntity: MovieDescriptionEntity)
}