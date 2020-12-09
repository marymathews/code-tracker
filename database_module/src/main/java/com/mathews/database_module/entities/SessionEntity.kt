package com.mathews.database_module.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import org.joda.time.DateTime

@Entity(tableName = "sessions")
data class SessionEntity(
    var title : String,

    @ColumnInfo(name = "problem_description")
    var problemDescription : String?,

    var site : String,

    var link : String?,

    var level : String,

    @ColumnInfo(name = "solution_description")
    var solutionDescription : String?,

    @ColumnInfo(name = "time_complexity")
    var timeComplexity : String?,

    @ColumnInfo(name = "space_complexity")
    var spaceComplexity : String?,

    var date : String,

    var time : String
) {
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0L

    @Ignore
    var dateInDateFormat : DateTime? = null
}