package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class Public(
    val endDateTime: String?,
    val startDateTime: String?,
    val startTBD: Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(endDateTime)
        parcel.writeString(startDateTime)
        parcel.writeByte(if (startTBD) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Public> {
        override fun createFromParcel(parcel: Parcel): Public {
            return Public(parcel)
        }

        override fun newArray(size: Int): Array<Public?> {
            return arrayOfNulls(size)
        }
    }
}