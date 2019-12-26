package com.example.sleeptracker

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(entities = [Sleep::class, People::class, Product::class], version = 1)
@Database(entities = arrayOf(Sleep::class), version = 1)
abstract class SleepDatabase: RoomDatabase() {
    //Create an instance of the DAO
    abstract fun sleepDao(): SleepDAO

    companion object {
        //Create an instance of the Room Database
        //Singleton prevents multiple instances of the database
        @Volatile //If the main already creates an instance, the remaining activities will not create another instance
        private var INSTANCE: SleepDatabase? = null

        fun getDatabase(context: Context): SleepDatabase {
            val tempDB = INSTANCE
            if(tempDB != null) {
                return tempDB
            }

            //Create an instance of the Database
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    SleepDatabase::class.java,
                    "sleep_db"
                ).build()
                INSTANCE = instance

                return instance
            }
        }
    }
}