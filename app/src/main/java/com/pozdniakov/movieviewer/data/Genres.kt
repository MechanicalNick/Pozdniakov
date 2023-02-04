package com.pozdniakov.movieviewer

import com.google.gson.annotations.SerializedName


data class Genres (

  @SerializedName("genre" ) var genre : String? = null

)