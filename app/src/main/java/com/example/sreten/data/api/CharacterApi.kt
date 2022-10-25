package com.example.sreten.data.api

import com.example.sreten.data.api.model.Character
import retrofit2.http.GET

interface CharacterApi {

    @GET(ApiConstants.END_POINT)
    suspend fun getCharacter() : List<Character>
}