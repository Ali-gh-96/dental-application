package com.example.myapplication
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context) : SQLiteOpenHelper(context, "USERDB2",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS2(USERID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT NOT NULL,LNAME TEXT NOT NULL, PWD TEXT NOT NULL, PHONE TEXT NOT NULL,EMAIL TEXT NOT NULL)" )
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}
