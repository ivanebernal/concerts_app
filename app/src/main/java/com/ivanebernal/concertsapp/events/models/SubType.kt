package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class SubType(
    val id: String?,
    val name: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SubType> {
        override fun createFromParcel(parcel: Parcel): SubType {
            return SubType(parcel)
        }

        override fun newArray(size: Int): Array<SubType?> {
            return arrayOfNulls(size)
        }
    }
}