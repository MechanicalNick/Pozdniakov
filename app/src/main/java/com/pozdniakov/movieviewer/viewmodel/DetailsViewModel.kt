package com.pozdniakov.movieviewer.viewmodel

import androidx.lifecycle.MutableLiveData
import com.pozdniakov.movieviewer.data.api.MovieDescription
import com.pozdniakov.movieviewer.api.MainRepository
import kotlinx.coroutines.*

class DetailsViewModel(private val repository: MainRepository) : BaseViewModel() {
    val description = MutableLiveData<MovieDescription>()
    fun getDescription(id: Int) {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = repository.getDescription(id)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    description.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }
}