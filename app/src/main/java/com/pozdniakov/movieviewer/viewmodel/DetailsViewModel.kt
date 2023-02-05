package com.pozdniakov.movieviewer.viewmodel

import androidx.lifecycle.MutableLiveData
import com.pozdniakov.movieviewer.api.MainRepository
import com.pozdniakov.movieviewer.data.api.MovieDescription
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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