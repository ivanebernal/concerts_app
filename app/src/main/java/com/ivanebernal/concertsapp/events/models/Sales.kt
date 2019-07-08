package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class Sales(
    val `public`: Public?,
    val presales: List<Presale>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Public::class.java.classLoader),
        parcel.createTypedArrayList(Presale)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(public, flags)
        parcel.writeTypedList(presales)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Sales> {
        override fun createFromParcel(parcel: Parcel): Sales {
            return Sales(parcel)
        }

        override fun newArray(size: Int): Array<Sales?> {
            return arrayOfNulls(size)
        }
    }
}