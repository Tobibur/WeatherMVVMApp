package com.tobibur.weathermvvmapp.helpers

import android.content.Context
import android.util.Log

inline fun Context.info(message: () -> Any?) {
    val tag = this.javaClass.simpleName
    if (Log.isLoggable(tag, Log.INFO)) {
        Log.i(tag, message()?.toString() ?: "null")
    }
}