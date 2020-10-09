package com.example.roomdatabase2.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabase2.dao.WordDao
import com.example.roomdatabase2.entity.Word

class WordRespository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    suspend fun insert(word: Word){
        wordDao.insert(word)
    }
}