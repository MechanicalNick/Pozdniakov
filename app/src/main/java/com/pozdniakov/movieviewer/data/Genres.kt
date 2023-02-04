package com.pozdniakov.movieviewer.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Genres(

    @SerializedName("genre") var genre: String? = null

) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(genre)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Genres> {
        override fun createFromParcel(parcel: Parcel): Genres {
            return Genres(parcel)
        }

        override fun newArray(size: Int): Array<Genres?> {
            return arrayOfNulls(size)
        }
    }
}