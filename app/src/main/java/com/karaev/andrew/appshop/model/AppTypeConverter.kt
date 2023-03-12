package com.karaev.andrew.appshop.model

import androidx.room.TypeConverter
import java.util.*

class AppTypeConverter {
    @TypeConverter
    fun toUUID(uuid: String?): UUID {
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun fromUUID(uuid: UUID?):String?{
        return uuid?.toString()
    }
}