package com.ivanebernal.concertsapp.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ivanebernal.concertsapp.events.models.Event
import io.reactivex.disposables.CompositeDisposable

class EventsViewModel: ViewModel() {
    private val events: MutableLiveData<List<Event>> = MutableLiveData()
    private val repo: EventsRepository = EventsRepositoryImpl()
    private val compositeDisposable = CompositeDisposable()

    fun fetchEvents(artistId: String) {
        val disposable = repo.getEvents(artistId)
            .subscribe(
                { response ->
                    events.value = response._embedded?.events ?: listOf()
                },
                {
                    //TODO: handle error
                }
            )
        compositeDisposable.add(disposable)
    }

    fun getEvents(): LiveData<List<Event>> = events

    fun unsubscribe() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}