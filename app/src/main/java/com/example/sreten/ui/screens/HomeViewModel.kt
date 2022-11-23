package com.example.sreten.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.sreten.data.api.model.Character
import com.example.sreten.data.repository.CharacterRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val characterRepo: CharacterRepo
) : ViewModel() {
    //Flow is more flexible but LiveData is easier to use between ViewModel and UI
    //asLiveData to turn flow we get back from method to LiveData
    val characters = characterRepo.getCharacters()
}
//OLD CODE
/*private val _state = MutableStateFlow(emptyList<Character>())
    val state: StateFlow<List<Character>>
    get() = _state //get() { return _state }
*//*ViewModel is a class that is responsible for preparing and managing the data for an Activity or a
Fragment. It also handles the communication of the Activity / Fragment with the rest of the
application (e.g. calling the business logic classes).*//*
    init {//However, suspending functions can only be invoked by another suspending function or within a coroutine.
        viewModelScope.launch {    //// Coroutine that will be canceled when the ViewModel is cleared.
            *//*repeat(5){
                val characters = characterRepo.getCharacter()
            _state.value = characters
            }*//*
            val characters = characterRepo.getCharacter()
            _state.value = characters
        }
    }*/