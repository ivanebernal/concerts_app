package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class GeneralInfo(
    val childRule: String?,
    val generalRule: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(childRule)
        parcel.writeString(generalRule)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GeneralInfo> {
        override fun createFromParcel(parcel: Parcel): GeneralInfo {
            return GeneralInfo(parcel)
        }

        override fun newArray(size: Int): Array<GeneralInfo?> {
            return arrayOfNulls(size)
        }
    }
}