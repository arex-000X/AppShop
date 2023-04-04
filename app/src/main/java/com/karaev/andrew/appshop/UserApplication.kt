package com.karaev.andrew.appshop

import android.app.Application
import android.content.Context
import com.karaev.andrew.appshop.authentication.repository.UserRepository

class UserApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        UserRepository.initialize(this)

    }


}