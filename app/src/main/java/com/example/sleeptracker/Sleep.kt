package com.example.sleeptracker

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "sleep")
class Sleep (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val startDate: Date,
    val endDate: Date,
    val sleepQuality: Int
) {

}