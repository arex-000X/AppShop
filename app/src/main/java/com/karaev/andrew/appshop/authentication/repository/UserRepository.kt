package com.karaev.andrew.appshop.authentication.repository

import androidx.lifecycle.LiveData
import com.karaev.andrew.appshop.model.UserDao
import com.karaev.andrew.appshop.model.UserModel

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<UserModel>> = userDao.readAllData()

     fun addUser(user: UserModel){
        userDao.addUser(user)
    }

}