package uz.coder.notesapp.models

interface NotesService {
    fun addNotes(notes: Notes)
    fun editNotes(notes: Notes)
    fun deleteNotes(id: Int)
    fun getNotesList(): List<Notes>
}