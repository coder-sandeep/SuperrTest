package com.codersandeep.superrtest.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class PreferenceManager {
    // Define a function to save an ArrayList of strings to SharedPreferences
//    fun saveArrayListToSharedPreferences(
//        context: Context,
//        key: String,
//        arrayList: ArrayList<Int>
//    ) {
//        val sharedPreferences: SharedPreferences =
//            context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
//        val editor: SharedPreferences.Editor = sharedPreferences.edit()
//
//        // Convert the ArrayList to a single string, using a delimiter (e.g., comma)
//        val arrayListAsString = arrayList.joinToString(",")
//
//        // Save the string in SharedPreferences
//        editor.putString(key, arrayListAsString)
//        editor.apply()
//    }
//
//    // Define a function to retrieve an ArrayList of strings from SharedPreferences
//    fun getArrayListFromSharedPreferences(context: Context, key: String): ArrayList<Int> {
//        val sharedPreferences: SharedPreferences =
//            context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
//
//        // Retrieve the string from SharedPreferences
//        val arrayListAsString = sharedPreferences.getString(key, "") ?: ""
//
//        // Convert the string back to an ArrayList using the same delimiter
//        val arrayList = arrayListAsString.split(",").toMutableList() as ArrayList<Int>
//
//        return arrayList
//    }

    fun saveIntArrayToSharedPreferences(context: Context, key: String, intArray: IntArray) {
        val sharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Convert the IntArray to a String
        val intArrayAsString = intArray.joinToString(",")

        editor.putString(key, intArrayAsString)
        editor.apply()
    }

    fun getIntArrayFromSharedPreferences(context: Context, key: String): IntArray {
        val sharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)
        val intArrayAsString = sharedPreferences.getString(key, "") ?: ""

        if (intArrayAsString.isEmpty()) {
            return IntArray(0)
        } else {
            val intArray = intArrayAsString.split(",").map { it.toInt() }.toIntArray()
            return intArray
        }
    }
}
