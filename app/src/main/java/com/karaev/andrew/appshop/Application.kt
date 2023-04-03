package com.karaev.andrew.appshop

import android.app.Application
import android.content.Context
 class Application:Application() {


  private  lateinit var context: Context


    override fun onCreate() {
        super.onCreate()
        com.karaev.andrew.appshop.Application().context = applicationContext
    }

     fun getAppContext(): Context? {
        return com.karaev.andrew.appshop.Application().context
    }

}