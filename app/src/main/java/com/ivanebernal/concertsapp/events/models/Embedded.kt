package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class Embedded(
    val events: List<Event>?
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(Event)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(events)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Embedded> {
        override fun createFromParcel(parcel: Parcel): Embedded {
            return Embedded(parcel)
        }

        override fun newArray(size: Int): Array<Embedded?> {
            return arrayOfNulls(size)
        }
    }
}