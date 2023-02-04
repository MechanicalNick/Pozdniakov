package com.pozdniakov.movieviewer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pozdniakov.movieviewer.data.MovieDescription
import com.pozdniakov.movieviewer.data.Popular
import com.pozdniakov.movieviewer.repository.MainRepository
import kotlinx.coroutines.*

class DetailsViewModel(private val repository: MainRepository) : ViewModel() {
    val errorMessage = MutableLiveData<String>()
    val description = MutableLiveData<MovieDescription>()
    var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getDescription(id : Int) {
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

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}