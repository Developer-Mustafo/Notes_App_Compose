package uz.coder.notesapp.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import uz.coder.notesapp.models.Notes

class MyDatabase(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION),
    DatabaseService {
    override fun onCreate(db: SQLiteDatabase) {
        val a = "create table " + TABLE_NAME + " (" +
                ID + " integer not null primary key autoincrement," +
                NAME + " text not null, " +
                NOTES + " text not null)"
        db.execSQL(a)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    override fun add(notes: Notes) {
        val readableDatabase = this.readableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAME, notes.name)
        contentValues.put(NOTES, notes.notes)
        readableDatabase.insert(TABLE_NAME, null, contentValues)
    }

    override fun edit(notes: Notes) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAME, notes.name)
        contentValues.put(NOTES, notes.notes)
        database.update(
            TABLE_NAME,
            contentValues,
            "$ID = ?",
            arrayOf(notes.id.toString())
        )
    }
    override fun delete(id:Int) {
        val database = this.writableDatabase
        database.delete(TABLE_NAME, "$ID = ?", arrayOf(id.toString()))
    }

    override fun allList(): List<Notes> {
        val notesModelList: MutableList<Notes> = ArrayList<Notes>()
        val database = this.writableDatabase
        val query = "SELECT * FROM notes"
        @SuppressLint("Recycle") val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val notesModel = Notes()
                notesModel.id = cursor.getString(0).toInt()
                notesModel.name = cursor.getString(1)
                notesModel.notes = cursor.getString(2)
                notesModelList.add(notesModel)
            } while (cursor.moveToNext())
        }
        return notesModelList
    }

    companion object {
        private const val DATABASE_NAME = "Notes_App_2023"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "notes"
        private const val ID = "id"
        private const val NAME = "name"
        private const val NOTES = "notes"
    }
}
