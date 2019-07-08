package com.ivanebernal.concertsapp.search.models

data class SearchResult(
    val _embedded: Embedded?,
    val _links: Links,
    val page: Page
)