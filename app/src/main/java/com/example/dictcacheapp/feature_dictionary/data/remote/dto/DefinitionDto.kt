package com.example.dictcacheapp.feature_dictionary.data.remote.dto

import com.example.dictcacheapp.feature_dictionary.domain.model.Definition

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
)