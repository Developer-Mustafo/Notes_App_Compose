package uz.coder.notesapp.models


data class Notes(
    var id:Int = UNDEFINE_ID,
    var name:String = "",
    var notes:String = ""
) {
companion object{
    const val UNDEFINE_ID = 0
}
}