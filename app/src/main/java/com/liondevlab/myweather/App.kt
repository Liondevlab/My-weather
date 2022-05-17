package com.liondevlab.myweather

import android.app.Application

/**
 * My Weather
 * Created by LioNDeVLaB on 17/05/2022
 */
class App : Application() {

    companion object {
        lateinit var instance: App

        val database: Database by lazy {
            Database(instance)
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}