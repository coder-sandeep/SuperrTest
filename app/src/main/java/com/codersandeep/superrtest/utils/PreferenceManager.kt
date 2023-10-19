package com.codersandeep.superrtest.utils

import android.content.Context
class PreferenceManager {
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
