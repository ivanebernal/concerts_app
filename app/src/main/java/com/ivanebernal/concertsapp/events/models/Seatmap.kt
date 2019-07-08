package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class Seatmap(
    val staticUrl: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(staticUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Seatmap> {
        override fun createFromParcel(parcel: Parcel): Seatmap {
            return Seatmap(parcel)
        }

        override fun newArray(size: Int): Array<Seatmap?> {
            return arrayOfNulls(size)
        }
    }
}