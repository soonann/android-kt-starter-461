package com.example.androidktstarter461

import android.app.Activity
import android.util.Log
import java.util.Random
import java.util.Scanner


class Utility {

    // hashmap - creating a hashmap of k,v
    private val userMap = HashMap<String,String>()

 
    // custom random function
    // inclusive lower bound with exclusive upper bound
    private fun pickRandomNumber(lowerBound: Int, upperBound: Int): Int{
        val rand = Random()
        val tmpUpperBound = upperBound - lowerBound

        // specify the non-inclusive upper bound
        return lowerBound + rand.nextInt(tmpUpperBound)
    }

    // USAGE:
    // creating a list of resources by their id
    // val files = listOf<Int>(
    //     R.raw...,
    //     R.raw...,
    //     R.raw...,
    //     R.raw...,
    // )

    // pick a random file within the bounds of file.size
    // val i = Random().nextInt(files.size)

    // reads the whole file into a string and returns it as a string
    private fun readFile(
        activity: Activity, // the activity context
        fileResourceId: Int // the resource file's id
    ): String{


        // create file and read file
        val sc = Scanner(activity.resources.openRawResource(fileResourceId))
        var res = ""
        while(sc.hasNextLine()){
            val line = sc.nextLine()
            res += line + "\n"
        }
        return res
    }


}