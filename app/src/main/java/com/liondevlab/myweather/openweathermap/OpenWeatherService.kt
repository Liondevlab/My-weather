package com.liondevlab.myweather.openweathermap

import com.liondevlab.myweather.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

/**
 * My Weather
 * Created by LioNDeVLaB on 23/05/2022
 */

private const val API_KEY = BuildConfig.API_KEY

interface OpenWeatherService {

    @GET("data/2.5/weather?units=metric&lang=fr")
    fun getWeather(@Query("q") cityName: String,
                   @Query("appid") apiKey: String = API_KEY) : Call<WeatherWrapper>

}