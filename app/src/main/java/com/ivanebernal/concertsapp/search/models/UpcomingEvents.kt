package com.ivanebernal.concertsapp.search.models

import android.os.Parcel
import android.os.Parcelable

data class UpcomingEvents(
    val _total: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(_total)
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