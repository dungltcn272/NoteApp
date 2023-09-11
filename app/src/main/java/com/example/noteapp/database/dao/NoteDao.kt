package com.example.noteapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteapp.model.Note

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("Select * From note_table")
    fun getAllNote(): LiveData<List<Note>>

    @Query("Select * From note_table where title_col =:title")
    fun getNoteTile(title: String) : LiveData<List<Note>>
}