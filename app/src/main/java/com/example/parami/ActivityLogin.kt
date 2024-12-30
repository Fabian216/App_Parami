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

class ActivityLogin : AppCompatActivity() {

    private lateinit var etcodusu : EditText
    private lateinit var etnomusu : EditText
    private lateinit var btnlogin : Button
    private lateinit var dbl : SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etcodusu = findViewById(R.id.etCodUsu2)
        etnomusu = findViewById(R.id.etNomUsu3)
        btnlogin = findViewById(R.id.btnLogin)
        dbl = SQLiteHelper(this)

        btnlogin.setOnClickListener{
            val txtCodusu = etcodusu.text.toString()
            val txtNomusu = etnomusu.text.toString()

            if (TextUtils.isEmpty(txtCodusu) || TextUtils.isEmpty(txtNomusu)){
                Toast.makeText(this,"Agrega tus fortalezas", Toast.LENGTH_SHORT).show()
            }
            else {
                val checkCodusu = dbl.comprobarUsuario(txtCodusu,txtNomusu)
                if (checkCodusu==true){
                    Toast.makeText(this,"Inicio exitoso", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this,"Fortalezas no registradas", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}