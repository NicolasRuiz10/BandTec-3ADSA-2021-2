package com.example.ipet

import API.ApiIpet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalheProduto : AppCompatActivity() {
    lateinit var etNomeProduto: TextView
    lateinit var etDescricao: TextView
    lateinit var etPreco: TextView
    lateinit var btAdicionar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_produto)
        etNomeProduto = findViewById((R.id.tv_nome_produto))
        etDescricao = findViewById((R.id.tv_descricao))
        etPreco = findViewById((R.id.tv_preco))
        btAdicionar = findViewById((R.id.button_adcionar))
        getProduto()
    }
    fun getProduto() {
        val id = intent.getStringExtra("idProduto").toString().toInt()
        val getProdutos = ApiIpet.criar().getDetalheProduto(id)
        getProdutos.enqueue(object : Callback<Produto>{
            override fun onResponse(call: Call<Produto>, response: Response<Produto>) {
                val produto = response.body()
                etNomeProduto.text = produto?.nome
                etDescricao.text = produto?.descricao
                etPreco.text = produto?.valor.toString()
                btAdicionar.text = "Adicionar    ${produto?.valor}"
            }

            override fun onFailure(call: Call<Produto>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na api", Toast.LENGTH_SHORT).show()
            }
        })
    }
}