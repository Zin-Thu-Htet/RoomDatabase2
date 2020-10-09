package com.example.roomdatabase2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase2.entity.Word
import com.example.roomdatabase2.viewmodel.WordViewmodel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var wordViewmodel: WordViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordViewmodel = ViewModelProvider(this).get(WordViewmodel::class.java)

        btnSave.setOnClickListener {
            val word = Word(edtWord.text.toString())
            wordViewmodel.insert(word)
        }

        wordViewmodel.allWords.observe(this, Observer {
            txtResult.text = it.size.toString()

        })
    }
}