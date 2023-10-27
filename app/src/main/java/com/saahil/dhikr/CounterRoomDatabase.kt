package com.saahil.dhikr

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Counter::class], version = 1, exportSchema = false)
public abstract class CounterRoomDatabase: RoomDatabase() {

    abstract fun counterDao(): CounterDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CounterRoomDatabase? = null

        fun getDatabase(context: Context): CounterRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CounterRoomDatabase::class.java,
                    "counter_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}