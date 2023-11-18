package com.example.androidktstarter461.sensors

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.androidktstarter461.R

class AccelerometerDemo : AppCompatActivity(), SensorEventListener{
    private lateinit var sensorMan: SensorManager
    private lateinit var accelerometer: Sensor
    private var color = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accelerometer_demo)

        // setup the sensor manager and get the default sensors
        sensorMan = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerometer = sensorMan.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        // set the background color of the field
        val tvAccel = findViewById<TextView>(R.id.tvAccelerometerOutput)
        tvAccel.setBackgroundColor(Color.GREEN)
    }

    override fun onResume() {
        super.onResume()
        // specify the delay of the sensor
        sensorMan.registerListener(this, accelerometer,SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorMan.unregisterListener(this)

    }

    override fun onSensorChanged(event: SensorEvent?) {
        val x = event!!.values[0]
        val y = event!!.values[1]
        val z = event!!.values[2]

        val accel = Math.sqrt((x * x + y * y + z * z).toDouble()).toFloat()
        val res = "Acceleration X: $x" +"Acceleration Y: $y" +"Acceleration Z: $z" +  "Acceleration: $accel"
        val tvAccel = findViewById<TextView>(R.id.tvAccelerometerOutput)
        tvAccel.text =  res

        if (accel > 30) {
            Toast.makeText(this, "Device was shaken", Toast.LENGTH_SHORT)
                    .show()
            if (color) {
                tvAccel.setBackgroundColor(Color.GREEN)
            } else {
                tvAccel.setBackgroundColor(Color.RED)
            }
            color = !color
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
}