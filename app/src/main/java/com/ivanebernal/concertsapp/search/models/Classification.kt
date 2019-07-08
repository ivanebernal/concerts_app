package com.ivanebernal.concertsapp.search.models

import android.os.Parcel
import android.os.Parcelable

data class Classification(
    val family: Boolean,
    val genre: Genre?,
    val primary: Boolean,
    val segment: Segment?,
    val subGenre: SubGenre?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readParcelable(Genre::class.java.classLoader),
        parcel.readByte() != 0.toByte(),
        parcel.readParcelable(Segment::class.java.classLoader),
        parcel.readParcelable(SubGenre::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (family) 1 else 0)
        parcel.writeParcelable(genre, flags)
        parcel.writeByte(if (primary) 1 else 0)
        parcel.writeParcelable(segment, flags)
        parcel.writeParcelable(subGenre, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Classification> {
        override fun createFromParcel(parcel: Parcel): Classification {
            return Classification(parcel)
        }

        override fun newArray(size: Int): Array<Classification?> {
            return arrayOfNulls(size)
        }
    }
}