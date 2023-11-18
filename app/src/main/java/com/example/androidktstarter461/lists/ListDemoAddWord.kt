package com.example.androidktstarter461.lists

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.androidktstarter461.R
import java.io.PrintStream

class ListDemoAddWord : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_word)

        setHints()
    }

    private fun setHints() {
        val it = intent
        val hintWord = it.getStringExtra("hintWord")
        val hintList = it.getStringExtra("hintList")

        val theWord = findViewById<EditText>(R.id.theWord)
        val theList = findViewById<EditText>(R.id.wordList)

        theWord.hint = hintWord
        theList.hint = hintList
    }

    fun addWordBtn(view: View) {
        val theWord = findViewById<EditText>(R.id.theWord)
        val wordList = findViewById<EditText>(R.id.wordList)

        try {
            val content = "${theWord.text.toString()}\t${wordList.text.toString()}"

            val outStream = PrintStream(openFileOutput("added_words.txt", MODE_APPEND))

            outStream.println(content)
            outStream.close()

            val intent = Intent()
            intent.putExtra("newWord", theWord.text.toString())
            intent.putExtra("newList", wordList.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        } catch (e: Exception) {
            Toast.makeText(this, "There are some error with adding words", Toast.LENGTH_SHORT).show()
            Log.d("error", e.toString())
        }
    }
}