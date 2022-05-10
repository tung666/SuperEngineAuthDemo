package com.superengine.auth.demo

import android.app.Application
import com.superengine.auth.sdk.SuperEngineAuth

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        SuperEngineAuth.init(this, true)
    }
}