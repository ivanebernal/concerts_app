package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class Presale(
    val endDateTime: String?,
    val name: String?,
    val startDateTime: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(endDateTime)
        parcel.writeString(name)
        parcel.writeString(startDateTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Presale> {
        override fun createFromParcel(parcel: Parcel): Presale {
            return Presale(parcel)
        }

        override fun newArray(size: Int): Array<Presale?> {
            return arrayOfNulls(size)
        }
    }
}