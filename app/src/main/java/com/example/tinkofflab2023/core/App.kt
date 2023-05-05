package com.example.tinkofflab2023.core

import android.app.Application
import android.content.Context

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this
    }

    companion object {
        private var INSTANCE: App? = null

        fun context(): Context {
            return requireNotNull(INSTANCE).applicationContext
        }
    }
}
