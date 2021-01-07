package com.thomy.lovedog.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Dog(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name:String,
    val image:Int,
    val description:String,
    val country:String
)
