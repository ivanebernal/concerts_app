package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class SelfX(
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

    companion object CREATOR : Parcelable.Creator<SelfX> {
        override fun createFromParcel(parcel: Parcel): SelfX {
            return SelfX(parcel)
        }

        override fun newArray(size: Int): Array<SelfX?> {
            return arrayOfNulls(size)
        }
    }
}