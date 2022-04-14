package com.example.ipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun irTelaCadastro(v: View) {
        val telaCadastro = Intent(this, Cadastro::class.java)
        startActivity(telaCadastro)
    }
}