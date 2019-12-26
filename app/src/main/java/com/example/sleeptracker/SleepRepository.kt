package com.example.sleeptracker

import androidx.lifecycle.LiveData

class SleepRepository (private val sleepDAO: SleepDAO) {
    val sleepList : LiveData< List<Sleep> > = sleepDAO.getSleep()

    suspend fun insertSleep (sleep:Sleep) {
        sleepDAO.insertSleep(sleep)
    }
}