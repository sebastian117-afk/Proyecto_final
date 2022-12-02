package com.example.sebas_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.widget.Toast
import com.example.sebas_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var idUser:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonLogin.setOnClickListener(){
            val intento1 = Intent(this,ActivityUsuario::class.java)

            val usuario = binding.textUser.text.toString()
            val contra = binding.textContra.text.toString()

            val dbConexion = DBusuario(this)
            val db = dbConexion.readableDatabase
            val cursor = db.rawQuery("SELECT * FROM ${FeedReaderContract.FeedEntry.nombreTabla}",null)

            if (cursor.moveToFirst()){
                do {
                    idUser = cursor.getInt(cursor.getColumnIndexOrThrow(BaseColumns._ID))
                    val itemUser = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.usuario))
                    val itemContra = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.contrasena))
                    if (usuario == itemUser && contra == itemContra){
                        Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT).show()
                        intento1.putExtra("user",itemUser)
                        intento1.putExtra("password",itemContra)
                        startActivity(intento1)
                        cursor.close()
                        db.close()
                        dbConexion.close()
                        return@setOnClickListener
                    }
                }while (cursor.moveToNext())
            }
            Toast.makeText(this,"Usuario o Contraseña incorrectos",Toast.LENGTH_SHORT).show()
            cursor.close()
            db.close()
            dbConexion.close()
        }

        binding.botonCrear.setOnClickListener(){
            val intento2 = Intent(this,ActivityCRUD::class.java)
            startActivity(intento2)
        }

    }
}