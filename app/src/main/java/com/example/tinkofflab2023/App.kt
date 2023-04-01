package com.example.tinkofflab2023

import android.app.Application
import com.github.terrakok.cicerone.Cicerone

class App : Application() {

    //todo вынести в di?
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }
}
