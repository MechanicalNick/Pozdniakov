package com.pozdniakov.movieviewer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pozdniakov.movieviewer.repository.MainRepository

class ViewModelFactory constructor(private val repository: MainRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PopularViewModel::class.java)) {
            PopularViewModel(this.repository) as T
        }
        else if(modelClass.isAssignableFrom(DetailsViewModel::class.java)){
            DetailsViewModel(this.repository) as T
        }
        else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}