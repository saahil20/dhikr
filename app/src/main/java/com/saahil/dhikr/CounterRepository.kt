package com.saahil.dhikr

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class CounterRepository(private val counterDao: CounterDao) {
    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allCounter: Flow<List<Counter>> = counterDao.getCounters()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(counter: Counter) {
        counterDao.insert(counter)
    }
}