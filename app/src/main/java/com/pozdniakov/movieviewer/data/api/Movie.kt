package com.pozdniakov.movieviewer.data.api

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Movie(

    @SerializedName("filmId") var filmId: Int? = null,
    @SerializedName("nameRu") var nameRu: String? = null,
    @SerializedName("nameEn") var nameEn: String? = null,
    @SerializedName("year") var year: String? = null,
    @SerializedName("filmLength") var filmLength: String? = null,
    @SerializedName("countries") var countries: ArrayList<Countries> = arrayListOf(),
    @SerializedName("genres") var genres: ArrayList<Genres> = arrayListOf(),
    @SerializedName("rating") var rating: String? = null,
    @SerializedName("ratingVoteCount") var ratingVoteCount: Int? = null,
    @SerializedName("posterUrl") var posterUrl: String? = null,
    @SerializedName("posterUrlPreview") var posterUrlPreview: String? = null,
    @SerializedName("ratingChange") var ratingChange: String? = null

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        arrayListOf<Countries>().apply {
            parcel.readArrayList(Countries::class.java.classLoader, Countries::class.java)
        },
        arrayListOf<Genres>().apply {
            parcel.readArrayList(Genres::class.java.classLoader, Genres::class.java)
        },
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(filmId)
        parcel.writeString(nameRu)
        parcel.writeString(nameEn)
        parcel.writeString(year)
        parcel.writeString(filmLength)
        parcel.writeParcelableList(countries, 0)
        parcel.writeParcelableList(genres, 0)
        parcel.writeString(rating)
        parcel.writeValue(ratingVoteCount)
        parcel.writeString(posterUrl)
        parcel.writeString(posterUrlPreview)
        parcel.writeString(ratingChange)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}