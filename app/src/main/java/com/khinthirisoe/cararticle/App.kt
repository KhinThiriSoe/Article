package com.khinthirisoe.cararticle

import android.app.Application
import com.khinthirisoe.cararticle.ui.connection.InternetUtil

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        InternetUtil.init(this)
    }
}