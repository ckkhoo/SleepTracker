package com.example.sleeptracker

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "sleep")
data class Sleep (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val startDate: Long = System.currentTimeMillis(),
    val endDate: Long,
    val sleepQuality: Int //1 to 5
)