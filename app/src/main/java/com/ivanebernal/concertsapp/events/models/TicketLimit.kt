package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class TicketLimit(
    val info: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(info)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TicketLimit> {
        override fun createFromParcel(parcel: Parcel): TicketLimit {
            return TicketLimit(parcel)
        }

        override fun newArray(size: Int): Array<TicketLimit?> {
            return arrayOfNulls(size)
        }
    }
}