package com.karaev.andrew.appshop.model

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun addUser(user: UserModel)

        @Query("SELECT * FROM users ORDER BY id ASC")
        fun readAllData(): LiveData<List<UserModel>>

}