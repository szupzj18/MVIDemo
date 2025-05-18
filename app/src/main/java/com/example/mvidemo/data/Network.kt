package com.example.mvidemo.data

import android.widget.Toast

sealed interface Result<out T> {
    data class Success<T>(val data: T)         : Result<T>
    data class Error(val throwable: Throwable) : Result<Nothing>
    object Loading                             : Result<Nothing>
}

class User {
}

fun handle(result: Result<User>) = when (result) {
    is Result.Success -> {}
    is Result.Error -> Toast.makeText(null, result.throwable.message, Toast.LENGTH_SHORT).show()
    is Result.Loading -> { /** show loading */ }
}
