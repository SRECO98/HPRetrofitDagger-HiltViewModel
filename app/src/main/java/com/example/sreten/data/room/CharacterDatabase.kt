package com.example.sreten.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sreten.data.api.model.RoomConvertorsActors
import com.example.sreten.data.api.model.Wand

@Database(entities = [com.example.sreten.data.api.model.Character::class, Wand::class], version = 1)
@TypeConverters(RoomConvertorsActors::class)
abstract class CharacterDatabase : RoomDatabase(){
    abstract fun characterDao(): CharacterDao
}