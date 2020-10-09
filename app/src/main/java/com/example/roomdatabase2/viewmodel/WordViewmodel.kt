package com.example.roomdatabase2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase2.database.WordDatabase
import com.example.roomdatabase2.entity.Word
import com.example.roomdatabase2.repository.WordRespository
import kotlinx.coroutines.launch

class WordViewmodel(application: Application): AndroidViewModel(application) {

    private val respository: WordRespository

    val allWords: LiveData<List<Word>>

    init{
        val wordDao = WordDatabase.getDatabase(application, viewModelScope)
            .wordDao()

        respository = WordRespository(wordDao)
        allWords = respository.allWords
    }
    fun insert(word: Word) = viewModelScope.launch {
        respository.insert(word)
    }
}