package com.liondevlab.myweather.city

/**
 * My Weather
 * Created by LioNDeVLaB on 17/05/2022
 */
class CityAdapter(private val cities: List<City>,
                  private val cityListener: CityAdapter.CityItemListener) {

    interface CityItemListener {
        fun onCitySelected(city: City)
        fun onCityDeleted(city: City)
    }
}