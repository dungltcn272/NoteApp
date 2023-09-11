package com.example.noteapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.model.Note

class NoteAdapter(private val context: Context, private val onClick: (Note) -> Unit, private val onDelete: (Note) -> Unit) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var notes: List<Note> = listOf()


    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val tvTitle =itemView.findViewById<TextView>(R.id.tvTitle)
        private val tvDescription =itemView.findViewById<TextView>(R.id.tvDescription)
        private val btnDelete =itemView.findViewById<ImageView>(R.id.btnDelete)
        private val layoutItem =itemView.findViewById<ConstraintLayout>(R.id.layoutItem)

        fun onBind(note: Note){
            tvTitle.text = note.title
            tvDescription.text =note.description

            btnDelete.setOnClickListener {
                onDelete(note)
            }

            layoutItem.setOnClickListener {
                onClick(note)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(notes[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNote(notes: List<Note>){
        this.notes=notes
        notifyDataSetChanged()
    }
}