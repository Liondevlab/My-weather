package com.liondevlab.myweather.weather

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

/**
 * My Weather
 * Created by LioNDeVLaB on 22/05/2022
 */
class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // we do not have to prepare activity layout and just replace content by the weather fragment
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, WeatherFragment.newInstance())
            .commit()
    }
}