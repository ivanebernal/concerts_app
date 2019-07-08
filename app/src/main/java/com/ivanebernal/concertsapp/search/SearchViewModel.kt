package com.ivanebernal.concertsapp.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ivanebernal.concertsapp.search.models.Attraction
import io.reactivex.disposables.CompositeDisposable

class SearchViewModel : ViewModel() {
    private val results: MutableLiveData<List<Attraction>> = MutableLiveData()
    private val repository: SearchRepository = SearchRepositoryImpl()
    private val compositeDisposable = CompositeDisposable()

    fun performSearch(query: String) {
        val disposable = repository.search(query)
            .subscribe(
                { result ->
                    results.value = result._embedded?.attractions ?: listOf()
                },
                {
                    //TODO: handle error
                }
            )
        compositeDisposable.add(disposable)
    }

    fun getResults(): LiveData<List<Attraction>> = results

    fun unsubscribe() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}