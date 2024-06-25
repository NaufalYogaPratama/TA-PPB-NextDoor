package com.example.tugasppb
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "mydatabase.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createUserTableQuery = "CREATE TABLE IF NOT EXISTS user (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)"
        db.execSQL(createUserTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS user")
        onCreate(db)
    }

    fun registerUser(username: String, password: String): Long {
        val db = writableDatabase
        val values = ContentValues()
        values.put("username", username)
        values.put("password", password)
        val id = db.insert("user", null, values)
        db.close()
        return id
    }

    fun loginUser(username: String, password: String): User? {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM user WHERE username = ? AND password = ?", arrayOf(username, password))
        val user: User?

        if (cursor.moveToFirst()) {
            val idIndex = cursor.getColumnIndex("id")
            val usernameIndex = cursor.getColumnIndex("username")
            val passwordIndex = cursor.getColumnIndex("password")

            val id = cursor.getInt(idIndex)
            val username = cursor.getString(usernameIndex)
            val password = cursor.getString(passwordIndex)

            user = User(id, username, password)
        } else {
            user = null
        }

        cursor.close()
        db.close()
        return user
    }
}
