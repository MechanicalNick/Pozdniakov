package com.pozdniakov.movieviewer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pozdniakov.movieviewer.repository.MainRepository
import com.pozdniakov.movieviewer.data.Popular
import kotlinx.coroutines.*

class PopularViewModel(private val repository: MainRepository) : ViewModel() {
    val errorMessage = MutableLiveData<String>()
    val popular = MutableLiveData<Popular>()
    var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

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

    private fun onError(message: String) {
        errorMessage.postValue(message)
        loading.postValue(false)
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}