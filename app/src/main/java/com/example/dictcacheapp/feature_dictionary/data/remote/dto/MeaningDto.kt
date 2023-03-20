package com.example.dictcacheapp.feature_dictionary.data.remote.dto

import com.example.dictcacheapp.feature_dictionary.data.mapper.toDefinition
import com.example.dictcacheapp.feature_dictionary.domain.model.Meaning

data class MeaningDto(
    val antonyms: List<String>,
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String,
    val synonyms: List<String>
)