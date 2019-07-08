package com.ivanebernal.concertsapp.events

import com.ivanebernal.concertsapp.BuildConfig
import com.ivanebernal.concertsapp.events.models.EventsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface EventsService {
    @GET("discovery/v2/events?apikey=${BuildConfig.TM_API_KEY}")
    fun getEvents(@Query("attractionId") artistId: String): Single<EventsResponse>
}