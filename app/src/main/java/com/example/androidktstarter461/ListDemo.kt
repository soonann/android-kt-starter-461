package com.example.androidktstarter461

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import java.io.File
import java.util.Scanner

class ListDemo : AppCompatActivity() {
    private lateinit var listAdapter: ArrayAdapter<String>
    private lateinit var spinnerAdapter: ArrayAdapter<String>

    private var wordsMap = HashMap<String, ArrayList<String>>()
    private var words = ArrayList<String>()
    private var displayList = ArrayList<String>()

    private lateinit var selectedWord: String
    private var selectedWordList = ArrayList<String>()

    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            val newWord = it.data!!.getStringExtra("newWord")
            val newList = it.data!!.getStringExtra("newList").toString().split(",")

            words.add(newWord!!)
            wordsMap[newWord] = newList as ArrayList<String>
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_demo)

        getAllWordsFromFiles()

        val wordsListView = findViewById<ListView>(R.id.listView)

        wordsListView.setOnItemClickListener{ list, item, index, id ->
            Toast.makeText(this, "Selected word: ${list.getItemAtPosition(index)}", Toast.LENGTH_SHORT).show()
        }

        val wordSpinner = findViewById<Spinner>(R.id.spinner)
        spinnerAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, words)
        wordSpinner.adapter = spinnerAdapter

        wordSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            // if an item is selected
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedWord = p0!!.getItemAtPosition(p2).toString()
                setUpList()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    private fun getAllWordsFromFiles() {

        val scanner1 = Scanner(resources.openRawResource(R.raw.help))
        readFile(scanner1)

        val file = File(filesDir.path + "/added_words.txt")
        if (file.exists()) {
            val scanner2 = Scanner(openFileInput("added_words.txt"))
            readFile(scanner2)
        }
    }

    private fun readFile(scanner: Scanner) {
        while(scanner.hasNextLine()) {
            val line = scanner.nextLine()
            val pieces = line.split("\t")
//
//            // split a string of words by comma
            val wordDesc = pieces[1].split(",")
//
            words.add(pieces[0])
            wordsMap[pieces[0]] = wordDesc as ArrayList<String>
        }
    }

    private fun setUpList() {
        displayList.clear()

        displayList = wordsMap[selectedWord]!!

        listAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, displayList)
        val wordsListView = findViewById<ListView>(R.id.listView)
        wordsListView.adapter = listAdapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val spinner = findViewById<Spinner>(R.id.spinner)
        selectedWord = spinner.selectedItem.toString()

        // use key-value pair to save the values during runtime and pass arnd?
        outState.putString("selectedWord", selectedWord)
        outState.putStringArrayList("displayList", displayList)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        selectedWord = savedInstanceState.getString("selectedWord").toString()
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = spinnerAdapter
        spinner.setSelection(spinnerAdapter.getPosition(selectedWord))
        selectedWordList = savedInstanceState.getStringArrayList("displayList")!!

        displayList.clear()
        displayList = selectedWordList
    }

    fun addWordBtnClicked(view: View) {
        val intent = Intent(this, AddNewWord::class.java)
        val hintWord = intent.putExtra("hintWord", "Enter new word here!")
        val hintDef = intent.putExtra("hintList", "Enter a comma separated string of words here!")
        getResult.launch(intent)
    }
}