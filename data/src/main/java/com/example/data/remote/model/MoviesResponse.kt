package com.example.data.remote.model

data class MoviesResponse(
    val docs: List<Doc>,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)