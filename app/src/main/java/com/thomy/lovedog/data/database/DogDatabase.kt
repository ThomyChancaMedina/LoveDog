package com.thomy.lovedog.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Dog::class], version = 1)
abstract class DogDatabase : RoomDatabase() {
    abstract fun DogDao(): DogDao
}