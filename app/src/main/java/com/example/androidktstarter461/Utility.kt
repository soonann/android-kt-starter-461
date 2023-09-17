package com.example.androidktstarter461

import java.util.Random


class Utility {

    // inclusive lower bound with exclusive upper bound
    private fun pickRandomNumber(lowerBound: Int, upperBound: Int): Int{
        val rand = Random()
        val tmpUpperBound = upperBound - lowerBound

        // specify the non-inclusive upper bound
        return lowerBound + rand.nextInt(tmpUpperBound)
    }

}