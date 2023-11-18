package com.example.androidktstarter461.files

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidktstarter461.R
import java.io.File
import java.io.FileNotFoundException
import java.io.PrintStream
import java.util.Scanner
import kotlin.Exception

class FileDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_demo)
        val filename = "switcheroo"

        try {
            writeInternalFile(filename, listOf<String>("abc", "123", "xyz"))
            writeInternalFile(filename, listOf<String>("abb", "123", "xyz"))
            val res = readInternalFile(filename)
            Log.d(this.localClassName, res.toString())
        } catch (e: Exception){
            Toast.makeText(this, e.message.toString(),  Toast.LENGTH_LONG).show()
            Log.d(this.localClassName, e.message.toString())
        }

    }

    // https://stackoverflow.com/questions/21230629/getfilesdir-vs-environment-getdatadirectory
    private fun readInternalFile(filename: String): List<String>{

        // get the file - filesDir gives us the path to the dir openFileInput/openFileOutput creates/reads their files in
        Log.d(this.localClassName, "Reading file from $filesDir and $filename")
        val file = File(filesDir.path + "/$filename")
        val content = ArrayList<String>()

        // if the file exists
        if (file.exists()) {
            // create an input stream and read the file
            val sc = Scanner(openFileInput(filename))
            while (sc.hasNext()){
                val line = sc.nextLine()
                content.add(line)
            }
        } else {
            // error handling or custom logic when file doesn't exist
            throw Exception("File Not Found")
        }

        return content
    }

    private fun writeInternalFile(filename: String, content: List<String>){
        // checks if file exists
        val file = File(filesDir.path + "/$filename")
        if (!file.exists()) {
        }
        Log.d(this.localClassName, "Reading file from $filesDir and $filename")
        val outStream = PrintStream(openFileOutput(filename, MODE_PRIVATE))
        for (line in content) {
            outStream.println(line)
        }
        outStream.close()

    }
}