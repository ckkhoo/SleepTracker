package com.example.sleeptracker

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SleepDAO {
    @Insert
    suspend fun insertSleep(sleep: Sleep) //suspend fun = makes this function as a call routine (co-routine?), put them in separate train

    @Query("SELECT * FROM sleep")
    fun getSleep(): LiveData< List<Sleep> >

    @Query("SELECT * FROM sleep WHERE id = :sleep_id")
    fun getASleep(sleep_id: Int): Sleep

    @Update
    suspend fun updateSleep(sleep: Sleep)

    @Delete
    suspend fun deleteSleep(sleep: Sleep)

    @Query("DELETE FROM sleep WHERE id = :sleep_id")
    suspend fun deleteSleep(sleep_id: Int)
}