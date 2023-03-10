package com.pozdniakov.movieviewer.data.api

import com.google.gson.annotations.SerializedName


data class Popular(

    @SerializedName("pagesCount") var pagesCount: Int? = null,
    @SerializedName("films") var films: ArrayList<Movie> = arrayListOf()

)