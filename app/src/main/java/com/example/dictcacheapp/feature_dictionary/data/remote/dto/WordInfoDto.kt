package com.example.dictcacheapp.feature_dictionary.data.remote.dto

import com.example.dictcacheapp.feature_dictionary.data.local.entity.WordInfoEntity

data class WordInfoDto(
    val license: License,
    val meanings: List<MeaningDto>,
    val phonetic: String?,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    val word: String
)