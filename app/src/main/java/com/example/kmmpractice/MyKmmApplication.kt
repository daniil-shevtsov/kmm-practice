package com.example.kmmpractice

import android.app.Application
import com.example.kmmpractice.common.di.initKoin
import com.example.kmmpractice.di.appModule
import org.koin.core.component.KoinComponent

class MyKmmApplication : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            modules(appModule)
        }
    }

}

