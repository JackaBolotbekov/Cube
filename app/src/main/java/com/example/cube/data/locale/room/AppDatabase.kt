package com.example.cube.data.locale.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cube.data.locale.room.daos.NoteDao
import com.example.cube.data.model.NoteModel

@Database(entities = [NoteModel::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}