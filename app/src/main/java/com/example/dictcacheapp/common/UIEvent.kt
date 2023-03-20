package com.example.dictcacheapp.common

sealed class UIEvent {
    data class ShowSnackbar(val message: String): UIEvent()
}
