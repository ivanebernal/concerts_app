package com.ivanebernal.concertsapp.search.models

import android.os.Parcel
import android.os.Parcelable

data class Attraction(
    val _links: Links?,
    val classifications: List<Classification>?,
    val externalLinks: ExternalLinks?,
    val id: String,
    val images: List<Image>?,
    val locale: String?,
    val name: String?,
    val test: Boolean,
    val type: String?,
    val upcomingEvents: UpcomingEvents?,
    val url: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Links::class.java.classLoader),
        parcel.createTypedArrayList(Classification),
        parcel.readParcelable(ExternalLinks::class.java.classLoader),
        parcel.readString(),
        parcel.createTypedArrayList(Image),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readParcelable(UpcomingEvents::class.java.classLoader),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(_links, flags)
        parcel.writeTypedList(classifications)
        parcel.writeParcelable(externalLinks, flags)
        parcel.writeString(id)
        parcel.writeTypedList(images)
        parcel.writeString(locale)
        parcel.writeString(name)
        parcel.writeByte(if (test) 1 else 0)
        parcel.writeString(type)
        parcel.writeParcelable(upcomingEvents, flags)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Attraction> {
        override fun createFromParcel(parcel: Parcel): Attraction {
            return Attraction(parcel)
        }

        override fun newArray(size: Int): Array<Attraction?> {
            return arrayOfNulls(size)
        }
    }
}