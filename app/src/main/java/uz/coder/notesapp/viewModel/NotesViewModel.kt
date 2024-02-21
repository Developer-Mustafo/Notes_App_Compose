package uz.coder.notesapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import uz.coder.notesapp.models.Notes
import uz.coder.notesapp.models.NotesServiceImpl

class NotesViewModel(application: Application):AndroidViewModel(application) {
    private val resource = NotesServiceImpl(application)
    fun getList() = resource.getNotesList()
    fun add(notes: Notes) = resource.addNotes(notes)
}