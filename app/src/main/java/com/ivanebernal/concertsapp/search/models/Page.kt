package com.ivanebernal.concertsapp.search.models

data class Page(
    val number: Int,
    val size: Int,
    val totalElements: Int,
    val totalPages: Int
)