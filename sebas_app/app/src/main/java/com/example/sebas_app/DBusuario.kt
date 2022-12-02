package com.example.sebas_app

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

object FeedReaderContract {
    // Table contents are grouped together in an anonymous object.
    object FeedEntry : BaseColumns {
        const val nombreTabla = "Usuarios"
        const val usuario =     "usuario"
        const val nombre =      "nombre"
        const val contrasena =  "contrasena"

    }
}

private const val sqlCreate =
    "CREATE TABLE ${FeedReaderContract.FeedEntry.nombreTabla} (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "${FeedReaderContract.FeedEntry.usuario} TEXT," +
            "${FeedReaderContract.FeedEntry.nombre} TEXT," +
            "${FeedReaderContract.FeedEntry.contrasena} TEXT)"

private const val sqlEliminar = "DROP TABLE IF EXISTS ${FeedReaderContract.FeedEntry.nombreTabla}"

class DBusuario (context: Context): SQLiteOpenHelper(context,DB_name,null,DB_version){
    companion object{
        private const val DB_version = 1
        private const val DB_name = "crud.db"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(sqlCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(sqlEliminar)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
}