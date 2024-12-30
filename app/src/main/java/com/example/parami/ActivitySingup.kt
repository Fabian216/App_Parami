package com.example.parami

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivitySingup : AppCompatActivity() {

    private lateinit var codUsuario : EditText
    private lateinit var nomUsuario : EditText
    private lateinit var repNomUsuario : EditText
    private lateinit var btnSingup : Button
    private lateinit var db : SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_singup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        codUsuario = findViewById(R.id.etCodUsu)
        nomUsuario = findViewById(R.id.etNomUsu)
        repNomUsuario = findViewById(R.id.etNomUsu2)
        btnSingup = findViewById(R.id.btnSingUp)
        db = SQLiteHelper(this)

        btnSingup.setOnClickListener{
            val codusuario = codUsuario.text.toString()
            val nomusuario = nomUsuario.text.toString()
            val repnomusuario = repNomUsuario.text.toString()
            val savedata = db.agregarUsuario(codusuario,nomusuario)

            if (TextUtils.isEmpty(codusuario) || TextUtils.isEmpty(nomusuario) || TextUtils.isEmpty(repnomusuario)){
                Toast.makeText(this,"Agrega tus fortalezas", Toast.LENGTH_SHORT).show()
            }
            else {
                if(nomusuario.equals(repnomusuario)){
                    if(savedata == true){
                        Toast.makeText(this,"registro exitoso", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, ActivityLogin::class.java)
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(this,"Usuario existe", Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    Toast.makeText(this,"Fortalezas no coinciden", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}