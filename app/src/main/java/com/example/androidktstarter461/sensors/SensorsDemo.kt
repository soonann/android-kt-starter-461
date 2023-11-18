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
import androidx.annotation.RequiresApi
import com.example.androidktstarter461.R

class SensorsDemo : AppCompatActivity(), SensorEventListener{

    private lateinit var sensorMan: SensorManager
    private lateinit var luminosity: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensors_demo)

        // get the sensor manager
        sensorMan = getSystemService(SENSOR_SERVICE) as SensorManager

        // get the list of sensors
        val sensorList = sensorMan.getSensorList(Sensor.TYPE_ALL)

        // display the name of the sensors in Log message
        for (s: Sensor in sensorList) {
            Log.i("SensorFound", "Found ${s.name}")
        }

        // get the light sensor
        luminosity = sensorMan.getDefaultSensor(Sensor.TYPE_LIGHT)!!
    }

    override fun onResume() {
        super.onResume()
        sensorMan.registerListener(this, luminosity, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorMan.unregisterListener(this)
    }

    // x y z axes for
    // event.values will give us [x, y, z] acceleration for accelerometer

    // create the EventListener
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onSensorChanged(event: SensorEvent?) {
        val lux = event!!.values[0] // curr lux
        val maxLux = luminosity.maximumRange // max lux

        val channel = (lux / maxLux) * 255
        window.decorView.setBackgroundColor(Color.rgb(channel, channel, channel))
    }

    // omitted intentionally
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}