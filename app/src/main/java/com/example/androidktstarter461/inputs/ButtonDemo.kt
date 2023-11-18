package com.example.androidktstarter461.inputs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.androidktstarter461.R

class ButtonDemo : AppCompatActivity() {

    private var number = 0

    // demo of how to use buttons with event listener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_demo)
    }

    // on click listener for the butotn
    // xml: you will have to assign this with the android:onClick="onButtonClick" attribute
    fun onButtonClick(view: View){
        val tvCounter = findViewById < TextView >(R.id.textViewCounter)

        // if the button clicked was the increase button
        if (view.id == R.id.buttonIncrease) {
            increase()
            Toast.makeText(this, "Number increased", Toast.LENGTH_SHORT)
        }
        // if the button clicked was the decrease button
        else if (view.id == R.id.buttonDecrease) {
            decrease()
            Toast.makeText(this, "Number decreased", Toast.LENGTH_SHORT)
        }

        // update the new number value
        tvCounter.text = number.toString()
    }

    // function to increase the state
    fun increase() {
        number++
    }

    // function to decrease the state
    fun decrease() {
        number--
    }



}