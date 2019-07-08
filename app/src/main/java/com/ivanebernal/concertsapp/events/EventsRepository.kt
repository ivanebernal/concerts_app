package com.ivanebernal.concertsapp.events

import com.ivanebernal.concertsapp.events.models.EventsResponse
import io.reactivex.Single

interface EventsRepository {
    fun getEvents(artistId: String): Single<EventsResponse>
}