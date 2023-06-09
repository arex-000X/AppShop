package com.karaev.andrew.appshop.authentication.viewmodel


import android.app.Application
import android.service.autofill.UserData
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karaev.andrew.appshop.authentication.repository.UserRepository
import com.karaev.andrew.appshop.model.UserDatabase
import com.karaev.andrew.appshop.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AuthViewModel(): ViewModel() {

    private val readAllData: LiveData<List<UserModel>>
    private val repository: UserRepository

    init {
        repository = UserRepository.get()
        readAllData = repository.readAllData
    }

    fun addUser(user: UserModel){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

}