package com.example.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note(
    @ColumnInfo(name = "title_col") var title: String = "",
    @ColumnInfo(name = "description_col") var description: String = "",
) : java.io.Serializable{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    var id: Int = 0
}