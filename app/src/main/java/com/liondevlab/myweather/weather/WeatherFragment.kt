package com.liondevlab.myweather.weather

import com.liondevlab.myweather.utils.toast
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.liondevlab.myweather.App
import com.liondevlab.myweather.R
import com.liondevlab.myweather.openweathermap.WeatherWrapper
import com.liondevlab.myweather.openweathermap.mapOpenWeatherDataToWeather
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * My Weather
 * Created by LioNDeVLaB on 22/05/2022
 */
class WeatherFragment: Fragment() {

    companion object {
        val EXTRA_CITY_NAME = "com.liondevlab.myweather.extras.EXTRA_CITY_NAME"

        fun newInstance() = WeatherFragment()
    }

    private val TAG = WeatherFragment::class.java.simpleName
    private lateinit var cityName: String
    private lateinit var countryCode: String

    private lateinit var cityText: TextView
    private lateinit var weatherIcon: ImageView
    private lateinit var weatherDescription: TextView
    private lateinit var temperatureText: TextView
    private lateinit var humidityText: TextView
    private lateinit var pressureText: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_weather, container, false)

        cityText = view.findViewById(R.id.weather_city_name)
        weatherIcon = view.findViewById(R.id.weather_icon)
        weatherDescription = view.findViewById(R.id.weather_description)
        temperatureText = view.findViewById(R.id.weather_temperature)
        humidityText = view.findViewById(R.id.weather_humidity)
        pressureText = view.findViewById(R.id.weather_pressure)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity?.intent!!.hasExtra(EXTRA_CITY_NAME)) {
            updateWeatherForCity(requireActivity().intent.getStringExtra(EXTRA_CITY_NAME)!!)
        } else {
            println("Could not find EXTRA_CITY_NAME")
        }
    }

    private fun updateWeatherForCity(cityName: String) {
        this.cityName = cityName
        countryCode = "fr"

        val call = App.weatherService.getWeather("$cityName,$countryCode")
        call.enqueue(object: Callback<WeatherWrapper> {
            override fun onResponse(call: Call<WeatherWrapper>, response: Response<WeatherWrapper>) {
                response.body()?.let {
                    val weather = mapOpenWeatherDataToWeather(it)
                    updateUI(weather)
                    Log.i(TAG, "OpenWeatherMap response: $weather")

                }
            }

            override fun onFailure(call: Call<WeatherWrapper>, t: Throwable) {
                Log.e(TAG, getString(R.string.error_message_could_not_load_city_weather), t)
                requireContext().toast(getString(R.string.error_message_could_not_load_city_weather))
            }

        })
    }

    private fun updateUI(weather: Weather) {

        Picasso.get()
            .load(weather.iconUrl)
            .placeholder(R.drawable.ic_baseline_cloud_circle_24)
            .into(weatherIcon)

        cityText.text = cityName
        weatherDescription.text = weather.description
        temperatureText.text = getString(R.string.weather_temperature_value, weather.temperature.toInt())
        humidityText.text = getString(R.string.weather_humidity_value, weather.humidity)
        pressureText.text = getString(R.string.weather_pressure_value, weather.pressure)
    }
}