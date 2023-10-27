package com.saahil.dhikr

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "counter")
data class Counter(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "total_count") val totalCount: Long,
    @ColumnInfo(name = "current_count") val currentCount: Int,
    @ColumnInfo(name = "daily_goal_limit") val dailyGoalLimit: Int
)