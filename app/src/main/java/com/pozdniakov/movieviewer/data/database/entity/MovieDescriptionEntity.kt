package com.pozdniakov.movieviewer.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pozdniakov.movieviewer.data.api.Countries
import com.pozdniakov.movieviewer.data.api.Genres
import java.util.ArrayList

@Entity(tableName = "movie_description")
class MovieDescriptionEntity {
    @PrimaryKey(autoGenerate = true)
    var filmId: Int? = null
    var posterUrlPreview: String? = null
    var posterUrl: String? = null
    var isFavourite: Boolean = false
    var name: String? = null
}