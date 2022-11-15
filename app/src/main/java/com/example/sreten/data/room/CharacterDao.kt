package com.example.sreten.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character")
    fun getAllCharacters(): Flow<List<com.example.sreten.data.api.model.Character>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(character: List<com.example.sreten.data.api.model.Character>)

    @Query("DELETE FROM character") //whenever we fetch new list of characters we will update our cache (deleting existing data and inserting enw ones from API)
    suspend fun deteleAllCharacters()
}