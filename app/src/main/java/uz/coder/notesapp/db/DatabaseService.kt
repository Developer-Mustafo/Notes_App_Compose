package uz.coder.notesapp.db

import uz.coder.notesapp.models.Notes

interface DatabaseService {
    fun add(notes: Notes)
    fun edit(notes: Notes)
    fun delete(id:Int)
    fun allList(): List<Notes>
}