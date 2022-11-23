package com.example.sreten.data.room

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.sreten.data.api.model.Wand
import com.google.common.truth.Truth.assertThat
import com.google.common.truth.IterableSubject
import org.junit.Assert.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

@RunWith(AndroidJUnit4::class)  // make sure all tests in this class will run on emulator
@SmallTest()  // First class of tests(Unit) of three classes (Unit, Integrated (Medium), UI(Large))
class CharacterDaoTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: CharacterDatabase
    private lateinit var dao: CharacterDao
    private val fakeChar = com.example.sreten.data.api.model.Character(
        "Sreten",
        true,
        listOf("Sreten", "Vasilije"),
        listOf("Sreten", "Vasilije"),
        "Sreten",
        "Sreten",
        "Sreten",
        "Sreten",
        "Sreten",
        true,
        true,
        "Sreten",
        "Sreten",
        "Sreten",
        "Sreten",
        "Sreten",
        wand = Wand("Sreten", "Sreten", "Sreten", ),
        true,
        "1998"
    )

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(  //this function will hold DB in RAM and not in persistent storage (saved only for test case)
            ApplicationProvider.getApplicationContext(),
            CharacterDatabase::class.java
        ).allowMainThreadQueries()   //we allow access to DB from Main Thread (In real app we ofc want to access DB from background Thread)
        .build()

        dao = database.characterDao()
    }

    @After
    fun teardown() = database.close()

    @Test  //RunBlocking is a way to execute courntines in a MainThread to bypass concurrency (multi-threading)
    fun insertCharacterItem() = runBlocking {

        dao.insertCharacters(listOf(fakeChar))
        val characters = dao.getAllCharacters()

        assertThat(characters).isIn(listOf(fakeChar))
    }

    @Test
    fun deleteCharacterItem() = runBlocking {
        dao.insertCharacters(listOf(fakeChar))
        dao.deteleAllCharacters()

        val characters = dao.getAllCharacters()
        assertThat(characters).isNotIn(listOf(fakeChar))
    }
}