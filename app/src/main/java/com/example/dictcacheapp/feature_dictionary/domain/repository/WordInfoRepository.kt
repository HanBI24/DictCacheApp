package com.example.dictcacheapp.feature_dictionary.domain.repository

import com.example.dictcacheapp.core.util.Resource
import com.example.dictcacheapp.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}