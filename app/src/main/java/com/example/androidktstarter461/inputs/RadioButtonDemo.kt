package com.example.androidktstarter461.inputs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.androidktstarter461.R

class RadioButtonDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button_demo)
    }

    fun onRadioButtonClick(view: View) {
        val imgView = findViewById<ImageView>(R.id.imageView)
        val txtView = findViewById<TextView>(R.id.textView)

        if (view.id == R.id.radioButtonCaptain) {
            imgView.setImageResource(R.drawable.captain_america)
            txtView.text = "Captain America"
        }
        else if (view.id == R.id.radioButtonIron) {
            imgView.setImageResource(R.drawable.ironman)
            txtView.text = "Iron Man"
        }
        else if (view.id == R.id.radioButtonSpider) {
            imgView.setImageResource(R.drawable.spiderman)
            txtView.text = "Spider Man"
        } else {
            imgView.setImageResource(R.drawable.thor)
            txtView.text = "Thor"
        }
    }

}