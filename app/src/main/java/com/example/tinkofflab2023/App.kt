package com.example.tinkofflab2023

import android.app.Application
import com.github.terrakok.cicerone.Cicerone


class App : Application() {


    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }
}
