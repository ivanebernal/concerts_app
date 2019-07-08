package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class EventsResponse(
    val _embedded: Embedded?,
    val _links: Links?,
    val page: Page?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Embedded::class.java.classLoader),
        parcel.readParcelable(Links::class.java.classLoader),
        parcel.readParcelable(Page::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(_embedded, flags)
        parcel.writeParcelable(_links, flags)
        parcel.writeParcelable(page, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EventsResponse> {
        override fun createFromParcel(parcel: Parcel): EventsResponse {
            return EventsResponse(parcel)
        }

        override fun newArray(size: Int): Array<EventsResponse?> {
            return arrayOfNulls(size)
        }
    }
}