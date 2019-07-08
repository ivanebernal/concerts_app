package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class EmbeddedX(
    val venues: List<Venue>?
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(Venue)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(venues)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EmbeddedX> {
        override fun createFromParcel(parcel: Parcel): EmbeddedX {
            return EmbeddedX(parcel)
        }

        override fun newArray(size: Int): Array<EmbeddedX?> {
            return arrayOfNulls(size)
        }
    }
}