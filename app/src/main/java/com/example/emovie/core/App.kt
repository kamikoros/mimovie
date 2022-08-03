package com.example.emovie.core

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class App:Application() {

    companion object {
        lateinit var context: Context

        fun contextApp():Context{
            return context
        }

    }
    override fun onCreate() {
        super.onCreate()
        context = this
    }

}