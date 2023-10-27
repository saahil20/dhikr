package com.saahil.dhikr

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CounterDao {

    @Query("SELECT * FROM counter")
    fun getCounters(): Flow<List<Counter>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(counter: Counter)

    @Query("DELETE FROM counter WHERE id=:id")
    suspend fun deleteAll(id: String)

}