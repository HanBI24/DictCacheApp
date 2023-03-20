package com.example.data.mapper

import com.example.data.local.entity.WordInfoEntity
import com.example.data.remote.dto.DefinitionDto
import com.example.data.remote.dto.MeaningDto
import com.example.data.remote.dto.WordInfoDto
import com.example.domain.model.Definition
import com.example.domain.model.Meaning
import com.example.domain.model.WordInfo


fun WordInfoEntity.toWordInfo(): WordInfo {
    return WordInfo(
        meanings = meanings,
        phonetic = phonetic,
        word = word
    )
}

fun WordInfoDto.toWordInfoEntity(): WordInfoEntity {
    return WordInfoEntity(
        meanings = meanings.map { it.toMeaning() },
        phonetic = phonetic,
        word = word
    )
}

fun DefinitionDto.toDefinition(): Definition {
    return Definition(
        antonyms = antonyms,
        definition = definition,
        example = example,
        synonyms = synonyms
    )
}

fun MeaningDto.toMeaning(): Meaning {
    return Meaning(
        antonyms = antonyms,
        definitions = definitions.map { it.toDefinition() },
        partOfSpeech = partOfSpeech,
        synonyms = synonyms
    )
}
