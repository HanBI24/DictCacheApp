package com.example.dictcacheapp.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictcacheapp.feature_dictionary.domain.model.Meaning
import com.example.dictcacheapp.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String?,
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
)
