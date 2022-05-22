package com.liondevlab.myweather.utils

import android.content.Context
import android.widget.Toast

/**
 * My Weather
 * Created by LioNDeVLaB on 22/05/2022
 */

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}