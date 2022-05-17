package com.liondevlab.myweather.city

/**
 * My Weather
 * Created by LioNDeVLaB on 17/05/2022
 */
data class City(var id: Long, var name: String) {

    constructor(name: String) : this(-1, name)

}