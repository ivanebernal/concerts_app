package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class UpcomingEvents(
    val _total: Int,
    val ticketmaster: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(_total)
        parcel.writeInt(ticketmaster)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UpcomingEvents> {
        override fun createFromParcel(parcel: Parcel): UpcomingEvents {
            return UpcomingEvents(parcel)
        }

        override fun newArray(size: Int): Array<UpcomingEvents?> {
            return arrayOfNulls(size)
        }
    }
}