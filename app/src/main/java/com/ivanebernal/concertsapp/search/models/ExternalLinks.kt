package com.ivanebernal.concertsapp.search.models

import android.os.Parcel
import android.os.Parcelable

data class ExternalLinks(
    val facebook: List<Facebook>?,
    val instagram: List<Instagram>?,
    val twitter: List<Twitter>?,
    val youtube: List<Youtube>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(Facebook),
        parcel.createTypedArrayList(Instagram),
        parcel.createTypedArrayList(Twitter),
        parcel.createTypedArrayList(Youtube)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(facebook)
        parcel.writeTypedList(instagram)
        parcel.writeTypedList(twitter)
        parcel.writeTypedList(youtube)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExternalLinks> {
        override fun createFromParcel(parcel: Parcel): ExternalLinks {
            return ExternalLinks(parcel)
        }

        override fun newArray(size: Int): Array<ExternalLinks?> {
            return arrayOfNulls(size)
        }
    }
}