package com.ivanebernal.concertsapp.search

import com.ivanebernal.concertsapp.BuildConfig
import com.ivanebernal.concertsapp.search.models.SearchResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("discovery/v2/attractions?apikey=${BuildConfig.TM_API_KEY}&segmentId=KZFzniwnSyZfZ7v7nJ")
    fun search(@Query("keyword") query: String): Single<SearchResult>
}