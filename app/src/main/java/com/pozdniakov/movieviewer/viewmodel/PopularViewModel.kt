package com.pozdniakov.movieviewer.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.pozdniakov.movieviewer.data.api.Popular
import com.pozdniakov.movieviewer.data.database.MovieDescriptionDatabase
import com.pozdniakov.movieviewer.data.database.MovieDescriptionRepository
import com.pozdniakov.movieviewer.data.database.entity.MovieDescriptionEntity
import com.pozdniakov.movieviewer.api.MainRepository
import kotlinx.coroutines.*

class PopularViewModel(private val repository: MainRepository, private val app: Application) :
    BaseViewModel(), IInsertViewModel {
    val popular = MutableLiveData<Popular>()

    private val movieDescriptionRepository: MovieDescriptionRepository

    init {
        val db = MovieDescriptionDatabase.getDataBase(app)
        movieDescriptionRepository = MovieDescriptionRepository(db.movieDescriptionDao())
    }

    override fun insert(description: MovieDescriptionEntity){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            movieDescriptionRepository.insert(description)
        }
    }

    fun getPopular() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = repository.getPopular()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    popular.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }
}