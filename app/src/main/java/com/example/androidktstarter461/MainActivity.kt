package com.example.androidktstarter461

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startRadioDemo()

    }

    // starts the button demo
    private fun startButtonDemo(){
        val intent = Intent(this, ButtonDemo::class.java)
        startActivity(intent)
    }

    // starts the list demo
    private fun startListDemo(){
        val intent = Intent(this, ListDemo::class.java)
        startActivity(intent)
    }

    // starts the radio button demo
    private fun startRadioDemo(){
        val intent = Intent(this, RadioButtonDemo::class.java)
        startActivity(intent)
    }

}