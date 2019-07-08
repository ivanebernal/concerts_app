package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class Promoter(
    val description: String?,
    val id: String?,
    val name: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
        parcel.writeString(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Promoter> {
        override fun createFromParcel(parcel: Parcel): Promoter {
            return Promoter(parcel)
        }

        override fun newArray(size: Int): Array<Promoter?> {
            return arrayOfNulls(size)
        }
    }
}