package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.Meaning

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String?,
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
)
