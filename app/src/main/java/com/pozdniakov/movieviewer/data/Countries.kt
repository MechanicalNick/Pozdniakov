package com.pozdniakov.movieviewer.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Countries (

  @SerializedName("country" ) var country : String? = null

) : Parcelable {
  constructor(parcel: Parcel) : this(parcel.readString()) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(country)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<Countries> {
    override fun createFromParcel(parcel: Parcel): Countries {
      return Countries(parcel)
    }

    override fun newArray(size: Int): Array<Countries?> {
      return arrayOfNulls(size)
    }
  }
}