package com.liondevlab.myweather.openweathermap

import com.google.gson.annotations.SerializedName

/**
 * My Weather
 * Created by LioNDeVLaB on 22/05/2022
 */

data class WeatherWrapper(
    val weather: Array<WeatherData>,
    val main: MainData
)

data class WeatherData(
    val description: String,
    val icon: String
)

class MainData(
    @SerializedName("temp") val temperature: Float,
    val pressure: Int,
    val humidity: Int
)

