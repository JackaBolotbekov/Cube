package com.example.cube.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NoteApp")
data class NoteModel(
    @ColumnInfo
    val title: String,
    @ColumnInfo
    var isChecked: Boolean = false,
    @ColumnInfo
    val delete: Boolean = false
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
