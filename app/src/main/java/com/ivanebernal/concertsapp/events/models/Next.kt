package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class Next(
    val href: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(href)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Next> {
        override fun createFromParcel(parcel: Parcel): Next {
            return Next(parcel)
        }

        override fun newArray(size: Int): Array<Next?> {
            return arrayOfNulls(size)
        }
    }
}