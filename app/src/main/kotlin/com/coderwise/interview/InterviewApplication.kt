package com.coderwise.interview

import android.app.Application
import com.coderwise.interview.data.di.dataModule
import com.coderwise.interview.ui.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class InterviewApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@InterviewApplication)
            modules(uiModule, dataModule)
        }
    }
}