package com.pozdniakov.movieviewer.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pozdniakov.movieviewer.api.MainRepository

class ViewModelFactory constructor(private val repository: MainRepository, private val app: Application)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PopularViewModel::class.java)) {
            PopularViewModel(this.repository, app) as T
        } else if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            DetailsViewModel(this.repository) as T
        }else if(modelClass.isAssignableFrom(FavouriteViewModel::class.java)){
            FavouriteViewModel(app) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}