package com.example.domain.model

sealed class Resources<T>(val data: T? = null) {
    class Success<T>(data: T): Resources<T>(data)
    class Error<T>(data: T? = null, val message: String): Resources<T>(data)
}