package com.ivanebernal.concertsapp.search.models

import android.os.Parcel
import android.os.Parcelable

data class SubGenre(
    val id: String?,
    val name: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SubGenre> {
        override fun createFromParcel(parcel: Parcel): SubGenre {
            return SubGenre(parcel)
        }

        override fun newArray(size: Int): Array<SubGenre?> {
            return arrayOfNulls(size)
        }
    }
}