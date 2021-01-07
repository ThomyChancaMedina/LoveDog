package com.thomy.lovedog.data.database

import androidx.room.*

@Dao
interface DogDao {

    @Query("SELECT * FROM Dog")
    fun getAllDog(): List<Dog>

    @Query("SELECT * FROM Dog WHERE id = :id")
    fun findById(id: Int): Dog


    @Query("SELECT * FROM Dog WHERE country = :country")
    fun findByCountry(country: String): List<Dog>

    @Query("SELECT COUNT(id) FROM Dog")
    fun dogCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDog(dog: List<Dog>)

    @Update
    fun updateDog(dog: Dog)
}