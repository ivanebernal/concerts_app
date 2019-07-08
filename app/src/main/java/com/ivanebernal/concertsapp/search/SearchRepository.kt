package com.ivanebernal.concertsapp.search

import com.ivanebernal.concertsapp.search.models.SearchResult
import io.reactivex.Single

interface SearchRepository {
    fun search(query: String): Single<SearchResult>
}