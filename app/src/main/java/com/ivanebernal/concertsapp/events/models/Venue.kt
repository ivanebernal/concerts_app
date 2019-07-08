package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class Venue(
    val _links: Links?,
    val address: Address?,
    val boxOfficeInfo: BoxOfficeInfo?,
    val city: City?,
    val country: Country?,
    val dmas: List<Dma>?,
    val generalInfo: GeneralInfo?,
    val id: String?,
    val images: List<Image>?,
    val locale: String?,
    val location: Location?,
    val markets: List<Market>?,
    val name: String?,
    val parkingDetail: String?,
    val postalCode: String?,
    val state: State?,
    val test: Boolean,
    val timezone: String?,
    val type: String?,
    val upcomingEvents: UpcomingEvents?,
    val url: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Links::class.java.classLoader),
        parcel.readParcelable(Address::class.java.classLoader),
        parcel.readParcelable(BoxOfficeInfo::class.java.classLoader),
        parcel.readParcelable(City::class.java.classLoader),
        parcel.readParcelable(Country::class.java.classLoader),
        parcel.createTypedArrayList(Dma),
        parcel.readParcelable(GeneralInfo::class.java.classLoader),
        parcel.readString(),
        parcel.createTypedArrayList(Image),
        parcel.readString(),
        parcel.readParcelable(Location::class.java.classLoader),
        parcel.createTypedArrayList(Market),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(State::class.java.classLoader),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(UpcomingEvents::class.java.classLoader),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(_links, flags)
        parcel.writeParcelable(address, flags)
        parcel.writeParcelable(boxOfficeInfo, flags)
        parcel.writeParcelable(city, flags)
        parcel.writeParcelable(country, flags)
        parcel.writeTypedList(dmas)
        parcel.writeParcelable(generalInfo, flags)
        parcel.writeString(id)
        parcel.writeTypedList(images)
        parcel.writeString(locale)
        parcel.writeParcelable(location, flags)
        parcel.writeTypedList(markets)
        parcel.writeString(name)
        parcel.writeString(parkingDetail)
        parcel.writeString(postalCode)
        parcel.writeParcelable(state, flags)
        parcel.writeByte(if (test) 1 else 0)
        parcel.writeString(timezone)
        parcel.writeString(type)
        parcel.writeParcelable(upcomingEvents, flags)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Venue> {
        override fun createFromParcel(parcel: Parcel): Venue {
            return Venue(parcel)
        }

        override fun newArray(size: Int): Array<Venue?> {
            return arrayOfNulls(size)
        }
    }
}