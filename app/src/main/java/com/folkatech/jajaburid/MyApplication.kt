package com.folkatech.jajaburid

import android.app.Application
import com.folkatech.jajaburid.data.di.networkModule
import com.folkatech.jajaburid.data.di.repository
import com.folkatech.jajaburid.data.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    repository,
                    viewModelModule
                )
            )
        }
    }
}