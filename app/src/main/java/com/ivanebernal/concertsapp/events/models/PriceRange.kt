package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class PriceRange(
    val currency: String?,
    val max: Double,
    val min: Double,
    val type: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(currency)
        parcel.writeDouble(max)
        parcel.writeDouble(min)
        parcel.writeString(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PriceRange> {
        override fun createFromParcel(parcel: Parcel): PriceRange {
            return PriceRange(parcel)
        }

        override fun newArray(size: Int): Array<PriceRange?> {
            return arrayOfNulls(size)
        }
    }
}