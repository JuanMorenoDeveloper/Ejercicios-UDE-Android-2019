package uy.edu.ude.asynctask.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDB(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    val createDb = "create table user (id integer primary key, name text not null)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createDb)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //Sin implementacion
    }
}