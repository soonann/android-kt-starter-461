package com.example.androidktstarter461

import java.util.Random


class Utility {

    // custom random function
    // inclusive lower bound with exclusive upper bound
    private fun pickRandomNumber(lowerBound: Int, upperBound: Int): Int{
        val rand = Random()
        val tmpUpperBound = upperBound - lowerBound

        // specify the non-inclusive upper bound
        return lowerBound + rand.nextInt(tmpUpperBound)
    }

    // build in random function

}