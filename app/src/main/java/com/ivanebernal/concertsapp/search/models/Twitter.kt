package com.ivanebernal.concertsapp.search.models

import android.os.Parcel
import android.os.Parcelable

data class Twitter(
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

    companion object CREATOR : Parcelable.Creator<Twitter> {
        override fun createFromParcel(parcel: Parcel): Twitter {
            return Twitter(parcel)
        }

        override fun newArray(size: Int): Array<Twitter?> {
            return arrayOfNulls(size)
        }
    }
}