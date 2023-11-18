package com.example.androidktstarter461.inputs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.androidktstarter461.R

class DiscountCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discount_calculator)
    }

    fun calculatePrice(view: View) {
        val originalPrice = findViewById<EditText>(R.id.priceText)
        val discountPercent = findViewById<EditText>(R.id.discountText)

        var discountedPrice = 0.0

        if (discountPercent.text.toString().toDouble() <= 1) {
            discountedPrice = originalPrice.text.toString().toDouble() * discountPercent.text.toString().toDouble()
        } else {
            discountedPrice = originalPrice.text.toString().toDouble() * (discountPercent.text.toString().toDouble() / 100)
        }

        val discountedPriceText = findViewById<TextView>(R.id.discountedPrice)
        discountedPriceText.text = "Discounted Price: " +  "%.2f".format(discountedPrice)
    }
}