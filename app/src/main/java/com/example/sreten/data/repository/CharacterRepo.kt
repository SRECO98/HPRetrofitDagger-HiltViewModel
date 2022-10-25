package com.example.sreten.data.repository

import com.example.sreten.data.api.CharacterApi
import com.example.sreten.data.api.model.Character
import javax.inject.Inject

class CharacterRepo @Inject constructor(
    private val characterApi: CharacterApi
) {
    suspend fun getCharacter(): List<Character>{
        return characterApi.getCharacter()
    }
}