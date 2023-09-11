package com.example.noteapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.adapter.NoteAdapter
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodel.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val noteViewModel : NoteViewModel by lazy {
        ViewModelProvider(this, NoteViewModel.NoteViewModelFactory(this.application))[NoteViewModel::class.java]
    }

    private lateinit var btnOpenAddNoteActivity: FloatingActionButton
    private lateinit var rcvNote :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initControls()
        initEvents()
    }

    private fun initEvents() {
        btnOpenAddNoteActivity =findViewById(R.id.btnOpenAddActivity)
        btnOpenAddNoteActivity.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initControls() {
        val adapter =NoteAdapter(this@MainActivity, onItemClick, onItemDelete)

        rcvNote =findViewById(R.id.rcvNote)
        rcvNote.setHasFixedSize(true)
        rcvNote.layoutManager =LinearLayoutManager(this)
        rcvNote.adapter =adapter
        noteViewModel.getAllNote().observe(this) {
            adapter.setNote(it)
        }
    }

    private val onItemClick :(Note) -> Unit = {

        val intent = Intent(this@MainActivity, UpdateNoteActivity::class.java)
        intent.putExtra("UPDATE_NOTE", it)
        startActivity(intent)
    }
    private val onItemDelete :(Note) -> Unit ={
        noteViewModel.deleteNote(it)
    }


}