package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class BoxOfficeInfo(
    val acceptedPaymentDetail: String?,
    val openHoursDetail: String?,
    val phoneNumberDetail: String?,
    val willCallDetail: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(acceptedPaymentDetail)
        parcel.writeString(openHoursDetail)
        parcel.writeString(phoneNumberDetail)
        parcel.writeString(willCallDetail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BoxOfficeInfo> {
        override fun createFromParcel(parcel: Parcel): BoxOfficeInfo {
            return BoxOfficeInfo(parcel)
        }

        override fun newArray(size: Int): Array<BoxOfficeInfo?> {
            return arrayOfNulls(size)
        }
    }
}