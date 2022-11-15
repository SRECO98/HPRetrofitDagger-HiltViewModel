package com.example.sreten.data.repository

import androidx.room.withTransaction
import com.example.sreten.data.api.CharacterApi
import com.example.sreten.data.api.model.Character
import com.example.sreten.data.room.CharacterDatabase
import com.example.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class CharacterRepo @Inject constructor(
    private val characterApi: CharacterApi,
    private val db: CharacterDatabase
) {
    private val characterDao = db.characterDao()
    fun getCharacters() = networkBoundResource( //networkBound.. is reusable so we can use it again with different data and dif API calls
        query = {
            characterDao.getAllCharacters()
        },
        fetch = {
            delay(2000)
            characterApi.getCharacter()
        },
        saveFetchResult = { characters ->
            db.withTransaction { //this block will be executed as one transaction WoW(so if inserting fails data won't be deleted!)
                characterDao.deteleAllCharacters()
                characterDao.insertCharacters(characters)
            }
        }
    )


    /*suspend fun getCharacter(): List<Character>{
        return characterApi.getCharacter()
    }*/
}