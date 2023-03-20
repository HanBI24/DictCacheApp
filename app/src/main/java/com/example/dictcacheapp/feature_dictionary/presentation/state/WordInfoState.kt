package com.example.dictcacheapp.feature_dictionary.presentation.state

import com.example.dictcacheapp.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
