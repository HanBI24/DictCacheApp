package com.example.data.remote.dto

import com.example.data.local.entity.WordInfoEntity

data class WordInfoDto(
    val license: License,
    val meanings: List<MeaningDto>,
    val phonetic: String?,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    val word: String
)