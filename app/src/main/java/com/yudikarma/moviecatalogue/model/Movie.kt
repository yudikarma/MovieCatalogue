package com.yudikarma.moviecatalogue.model

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val id:String = "",
    val poster: String = "",
    val name:String = "",
    val rilis:String = "",
    val description:String = "",
    val rating:String = ""
    ):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(id)
        dest?.writeString(poster)
        dest?.writeString(name)
        dest?.writeString(rilis)
        dest?.writeString(description)
        dest?.writeString(rating)
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