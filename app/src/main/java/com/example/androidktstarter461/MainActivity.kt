package com.example.androidktstarter461

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.androidktstarter461.files.FileDemo
import com.example.androidktstarter461.inputs.ButtonDemo
import com.example.androidktstarter461.inputs.DiscountCalculator
import com.example.androidktstarter461.inputs.RadioButtonDemo
import com.example.androidktstarter461.lists.ListDemo
import com.example.androidktstarter461.sensors.AccelerometerDemo
import com.example.androidktstarter461.sensors.LuminosityDemo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    // starts the files demo
    fun onFilesDemo(view: View){
        val intent = Intent(this, FileDemo::class.java)
        startActivity(intent)
    }

    // starts the accel demo
    fun onAcceleratorDemo(view: View){
        val intent = Intent(this, AccelerometerDemo::class.java)
        startActivity(intent)
    }

    // starts the sensors demo
    fun onSensorsDemo(view: View){
        val intent = Intent(this, LuminosityDemo::class.java)
        startActivity(intent)
    }

    // starts the button demo
    fun startButtonDemo(view: View){
        val intent = Intent(this, ButtonDemo::class.java)
        startActivity(intent)
    }

    // starts the list demo
    fun startListDemo(view: View){
        val intent = Intent(this, ListDemo::class.java)
        startActivity(intent)
    }

    // starts the radio button demo
    fun startRadioDemo(view: View){
        val intent = Intent(this, RadioButtonDemo::class.java)
        startActivity(intent)
    }

    fun calculator(view: View) {
        val intent = Intent(this, DiscountCalculator::class.java)
        startActivity(intent)
    }

}