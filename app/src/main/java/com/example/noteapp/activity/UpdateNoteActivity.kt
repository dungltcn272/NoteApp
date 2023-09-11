package com.example.noteapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.R
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodel.NoteViewModel

class UpdateNoteActivity : AppCompatActivity() {

    private val noteViewModel : NoteViewModel by lazy {
        ViewModelProvider(this, NoteViewModel.NoteViewModelFactory(this.application))[NoteViewModel::class.java]
    }

    private lateinit var edtTitle : EditText
    private lateinit var edtDescription : EditText
    private lateinit var btnUpdateNote : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_note_actiity)

        edtTitle =findViewById(R.id.edtTitle)
        edtDescription =findViewById(R.id.edtDescription)
        btnUpdateNote =findViewById(R.id.btnUpdateNote)

        @Suppress("DEPRECATION")
        val note =intent.getSerializableExtra("UPDATE_NOTE") as Note

        edtTitle.setText(note.title)
        edtDescription.setText(note.description)

        btnUpdateNote.setOnClickListener {
            note.title =edtTitle.text.toString()
            note.description=edtDescription.text.toString()
            noteViewModel.updateNote(note)
            finish()
        }
    }
}