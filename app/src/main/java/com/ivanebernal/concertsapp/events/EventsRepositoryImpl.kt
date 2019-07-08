package com.ivanebernal.concertsapp.events

import com.ivanebernal.concertsapp.RetrofitSingleton
import com.ivanebernal.concertsapp.events.models.EventsResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EventsRepositoryImpl: EventsRepository {

    val eventsService = RetrofitSingleton.getInstance().create(EventsService::class.java)

    override fun getEvents(artistId: String): Single<EventsResponse> {
        return eventsService.getEvents(artistId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}