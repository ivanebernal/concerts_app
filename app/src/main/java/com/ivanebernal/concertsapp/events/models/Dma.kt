package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class Dma(
    val id: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dma> {
        override fun createFromParcel(parcel: Parcel): Dma {
            return Dma(parcel)
        }

        override fun newArray(size: Int): Array<Dma?> {
            return arrayOfNulls(size)
        }
    }
}