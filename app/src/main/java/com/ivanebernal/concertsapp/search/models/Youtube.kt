package com.ivanebernal.concertsapp.search.models

import android.os.Parcel
import android.os.Parcelable

data class Youtube(
    val url: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Youtube> {
        override fun createFromParcel(parcel: Parcel): Youtube {
            return Youtube(parcel)
        }

        override fun newArray(size: Int): Array<Youtube?> {
            return arrayOfNulls(size)
        }
    }
}