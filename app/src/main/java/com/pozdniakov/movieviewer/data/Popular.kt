package com.pozdniakov.movieviewer.data

import com.google.gson.annotations.SerializedName
import com.pozdniakov.movieviewer.data.Movie


data class Popular (

  @SerializedName("pagesCount" ) var pagesCount : Int?             = null,
  @SerializedName("films"      ) var films      : ArrayList<Movie> = arrayListOf()

)