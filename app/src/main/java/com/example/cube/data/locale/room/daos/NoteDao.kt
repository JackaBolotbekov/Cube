package com.example.cube.data.locale.room.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cube.data.model.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(noteModel: NoteModel)

    @Delete
    fun delete(noteModel: NoteModel)

    @Query("SELECT * FROM NoteApp")
    fun getALLModels(): LiveData<List<NoteModel>>
}