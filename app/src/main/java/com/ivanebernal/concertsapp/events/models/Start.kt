package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class Start(
    val dateTBA: Boolean,
    val dateTBD: Boolean,
    val dateTime: String?,
    val localDate: String?,
    val localTime: String?,
    val noSpecificTime: Boolean,
    val timeTBA: Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (dateTBA) 1 else 0)
        parcel.writeByte(if (dateTBD) 1 else 0)
        parcel.writeString(dateTime)
        parcel.writeString(localDate)
        parcel.writeString(localTime)
        parcel.writeByte(if (noSpecificTime) 1 else 0)
        parcel.writeByte(if (timeTBA) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Start> {
        override fun createFromParcel(parcel: Parcel): Start {
            return Start(parcel)
        }

        override fun newArray(size: Int): Array<Start?> {
            return arrayOfNulls(size)
        }
    }
}