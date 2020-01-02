package com.example.sleeptracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SleepViewModel (application: Application) : AndroidViewModel(application) {
    // The ViewModel maintains a reference to the repository to get data.
    private val sleepRepository: SleepRepository
    // LiveData gives us updated words when they change.
    val sleepList: LiveData< List<Sleep> >

    init {
        // Gets reference to SleepDAP from SleepDatabase to construct
        // the correct SleepRepository.
        val sleepDAO = SleepDatabase.getDatabase(application).sleepDao()
        sleepRepository = SleepRepository(sleepDAO)
        sleepList = sleepRepository.sleepList
    }

    //Execute a co-routine
    //viewModelScope or globalScope (in Activity)
    fun insertSleep(sleep:Sleep) = viewModelScope.launch {
        sleepRepository.insertSleep(sleep)
    }
}