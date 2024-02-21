package uz.coder.notesapp.sealed

sealed class NotesScreens(val route:String = NOTHING) {
    data object Home:NotesScreens(HOME)
    data object Add:NotesScreens(ADD)
    data object Notes:NotesScreens(NOTES)
companion object{
    private const val HOME = "home"
    private const val ADD = "add"
    private const val NOTHING = "."
    private const val NOTES = "notes"
}
}