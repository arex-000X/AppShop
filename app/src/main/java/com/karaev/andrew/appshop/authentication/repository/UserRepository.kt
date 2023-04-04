package com.karaev.andrew.appshop.authentication.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.karaev.andrew.appshop.model.UserDatabase
import com.karaev.andrew.appshop.model.UserModel

class UserRepository(application: Context) {
    val userDao = UserDatabase.getDatabase(application).userDao()
    val readAllData: LiveData<List<UserModel>> = userDao.readAllData()

     fun addUser(user: UserModel){
        userDao.addUser(user)
    }



    companion object {
        private var INSTANCE: UserRepository? = null
         fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = UserRepository(context)
            }
        }

        fun get(): UserRepository {
            return INSTANCE ?: throw IllegalStateException("CrimeRepository must be initialization")
        }

    }

}