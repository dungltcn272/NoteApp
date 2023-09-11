package com.example.noteapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.R
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodel.NoteViewModel

class AddNoteActivity : AppCompatActivity() {

    private val noteViewModel : NoteViewModel by lazy {
        ViewModelProvider(this, NoteViewModel.NoteViewModelFactory(this.application))[NoteViewModel::class.java]
    }

    private lateinit var edtTitle : EditText
    private lateinit var edtDescription : EditText
    private lateinit var btnAddNote : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note_actiity)

        edtTitle =findViewById(R.id.edtTitle)
        edtDescription =findViewById(R.id.edtDescription)
        btnAddNote =findViewById(R.id.btnAddNote)

        btnAddNote.setOnClickListener {
            val note = Note(edtTitle.text.toString().trim(), edtDescription.text.toString().trim())
            noteViewModel.insertNote(note)
            finish()
        }
    }
}