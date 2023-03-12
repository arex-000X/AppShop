package com.karaev.andrew.appshop.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.PasswordAuthentication
import java.util.UUID
@Entity(tableName = "users")
data class UserModel(
    @PrimaryKey
    var id: UUID = UUID.randomUUID(),
    var firstName: String,
    var lastName: String,
    var mail: String,
    var role:String  = "User-Defoult",
    var passwrod:String = ""
)
