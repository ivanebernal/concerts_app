package com.ivanebernal.concertsapp.events.models

import android.os.Parcel
import android.os.Parcelable

data class Event(
    val _embedded: EmbeddedX?,
    val classifications: List<Classification>?,
    val dates: Dates?,
    val id: String?,
    val images: List<Image>?,
    val locale: String?,
    val name: String?,
    val priceRanges: List<PriceRange>?,
    val products: List<Product>?,
    val promoter: Promoter?,
    val promoters: List<Promoter>?,
    val sales: Sales?,
    val seatmap: Seatmap?,
    val test: Boolean,
    val ticketLimit: TicketLimit?,
    val type: String?,
    val url: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(EmbeddedX::class.java.classLoader),
        parcel.createTypedArrayList(Classification),
        parcel.readParcelable(Dates::class.java.classLoader),
        parcel.readString(),
        parcel.createTypedArrayList(Image),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(PriceRange),
        parcel.createTypedArrayList(Product),
        parcel.readParcelable(Promoter::class.java.classLoader),
        parcel.createTypedArrayList(Promoter),
        parcel.readParcelable(Sales::class.java.classLoader),
        parcel.readParcelable(Seatmap::class.java.classLoader),
        parcel.readByte() != 0.toByte(),
        parcel.readParcelable(TicketLimit::class.java.classLoader),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(_embedded, flags)
        parcel.writeTypedList(classifications)
        parcel.writeParcelable(dates, flags)
        parcel.writeString(id)
        parcel.writeTypedList(images)
        parcel.writeString(locale)
        parcel.writeString(name)
        parcel.writeTypedList(priceRanges)
        parcel.writeTypedList(products)
        parcel.writeParcelable(promoter, flags)
        parcel.writeTypedList(promoters)
        parcel.writeParcelable(sales, flags)
        parcel.writeParcelable(seatmap, flags)
        parcel.writeByte(if (test) 1 else 0)
        parcel.writeParcelable(ticketLimit, flags)
        parcel.writeString(type)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Event> {
        override fun createFromParcel(parcel: Parcel): Event {
            return Event(parcel)
        }

        override fun newArray(size: Int): Array<Event?> {
            return arrayOfNulls(size)
        }
    }
}