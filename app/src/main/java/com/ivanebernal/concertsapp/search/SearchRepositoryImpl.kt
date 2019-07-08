package com.ivanebernal.concertsapp.search

import com.ivanebernal.concertsapp.RetrofitSingleton
import com.ivanebernal.concertsapp.search.models.SearchResult
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchRepositoryImpl : SearchRepository {
    private val searchService = RetrofitSingleton.getInstance().create(SearchService::class.java)

    override fun search(query: String): Single<SearchResult> {
        return searchService.search(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}