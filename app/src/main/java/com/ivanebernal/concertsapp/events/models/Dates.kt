package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class Dates(
    val spanMultipleDays: Boolean,
    val start: Start?,
    val status: Status?,
    val timezone: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readParcelable(Start::class.java.classLoader),
        parcel.readParcelable(Status::class.java.classLoader),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (spanMultipleDays) 1 else 0)
        parcel.writeParcelable(start, flags)
        parcel.writeParcelable(status, flags)
        parcel.writeString(timezone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dates> {
        override fun createFromParcel(parcel: Parcel): Dates {
            return Dates(parcel)
        }

        override fun newArray(size: Int): Array<Dates?> {
            return arrayOfNulls(size)
        }
    }
}