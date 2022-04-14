package com.example.ipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
    }
    fun irTelaLogin(v: View) {
        val telaLogin = Intent(this, Login::class.java)
        startActivity(telaLogin)
    }
}