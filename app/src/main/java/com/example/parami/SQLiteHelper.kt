package com.example.parami

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context): SQLiteOpenHelper(context,"Yo.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USUARIOS (ID INTEGER PRIMARY KEY AUTOINCREMENT,CODUSU TEXT,NOMUSU TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS USUARIOS")
    }

    fun agregarUsuario(codusu : String, nomusu : String): Boolean {
        val p0 = this.writableDatabase
        val cv = ContentValues()

        cv.put("CODUSU", codusu)
        cv.put("NOMUSU", nomusu)

        val result = p0.insert("USUARIOS",null,cv)
        if (result == -1 .toLong()){
            return false
        }
        return true
    }

    fun comprobarUsuario(codusu : String, nomusu : String): Boolean {
        val p0 = this.writableDatabase
        val query = "SELECT * FROM USUARIOS WHERE CODUSU = '$codusu' AND NOMUSU = '$nomusu'"
        val cursor = p0.rawQuery(query,null)

        if (cursor.count <= 0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }


}