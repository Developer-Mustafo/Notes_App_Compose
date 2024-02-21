package uz.coder.notesapp.models

import android.content.Context
import uz.coder.notesapp.db.MyDatabase

class NotesServiceImpl(context: Context):NotesService {
    private val db = MyDatabase(context)
    override fun addNotes(notes: Notes) {
        db.add(notes)
    }

    override fun editNotes(notes: Notes) {
        db.edit(notes)
    }

    override fun deleteNotes(id: Int) {
        db.delete(id)
    }

    override fun getNotesList(): List<Notes> {
        return db.allList()
    }
}