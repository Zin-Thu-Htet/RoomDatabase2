package com.example.roomdatabase2.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomdatabase2.entity.Word


@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun  getAllWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)
}