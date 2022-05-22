package com.liondevlab.myweather.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.liondevlab.myweather.R

/**
 * My Weather
 * Created by LioNDeVLaB on 22/05/2022
 */
class WeatherFragment: Fragment() {

    companion object {
        val EXTRA_CITY_NAME = "com.liondevlab.myweather.extras.EXTRA_CITY_NAME"

        fun newInstance() = WeatherFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather, container, false)
        return view
    }
}