package com.example.data.remote.model

data class Doc(
    val id: Int,
    val name: String,
    val poster: Poster,
    val description: String,
    val rate: Rating,
    val year: Int
)