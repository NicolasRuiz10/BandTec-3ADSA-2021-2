package com.example.ipet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class Produto: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        val dadosProduto = intent.extras
        var nomeProduto = dadosProduto?.getString("nomeProduto")
        var descricao = dadosProduto?.getString("descricao")
        var valor = dadosProduto?.getInt("valor")

        println("VALLLLOR"+ valor)
        var idPetshop = dadosProduto?.getInt("idPetshop")
        var idProduto = dadosProduto?.getInt("idProduto")


        val tv_nomeProduto = findViewById<TextView>(R.id.tv_nome_produto)
        tv_nomeProduto.text = nomeProduto

        val tv_descProduto = findViewById<TextView>(R.id.tv_desc_produto)
        tv_descProduto.text = descricao

        val tv_preco_produto = findViewById<TextView>(R.id.tv_preco_produto)
        tv_preco_produto.text = "$valor,00"
    }

    fun adicionarProduto(view: View) {
        val quantidade = findViewById<TextView>(R.id.tv_quantidade_produto)
        val valorProduto = findViewById<TextView>(R.id.tv_preco_produto)
        val qtd = Integer.parseInt(quantidade.text.toString()) + 1
        quantidade.text = qtd.toString()
        val dadosProduto = intent.extras
        var preco = dadosProduto?.getInt("valor")
        var somaValorTotal = preco.toString().toInt() * quantidade.text.toString().toInt()
        valorProduto.text = "$somaValorTotal,00"
    }

    fun subtrairProduto(view: View) {
        val quantidade = findViewById<TextView>(R.id.tv_quantidade_produto)
        val valorProduto = findViewById<TextView>(R.id.tv_preco_produto)
        var qtd = 1
        if (quantidade.text.toString().toInt() > 2) {
            qtd = Integer.parseInt(quantidade.text.toString()) - 1
        }
        quantidade.text = qtd.toString()

        val dadosProduto = intent.extras
        var preco = dadosProduto?.getInt("valor")
        var somaValorTotal = preco.toString().toInt() * quantidade.text.toString().toInt()
        valorProduto.text = "$somaValorTotal,00"
    }

    fun irTelaCarrinho(v: View) {
        val dadosUsuario = intent.extras
        var idUsuario = dadosUsuario?.getInt("idUsuario")
        val telaCarrinho = Intent(this, Carrinho::class.java)
        val quantidade = findViewById<TextView>(R.id.tv_quantidade_produto)
        val dadosProduto = intent.extras

        var nomeProduto = dadosProduto?.getString("nomeProduto")
        var valor = dadosProduto?.getInt("valor")
        var descricao = dadosProduto?.getString("descricao")
        var idPetshop = dadosProduto?.getInt("idpet")
        var idProduto = dadosProduto?.getInt("idProduto")
        telaCarrinho.putExtra("idUsuario", idUsuario)
        telaCarrinho.putExtra("nomeProduto", nomeProduto)
        telaCarrinho.putExtra("valor", valor)
        telaCarrinho.putExtra("descricao", descricao)
        telaCarrinho.putExtra("idpet", idPetshop)
        telaCarrinho.putExtra("idProduto", idProduto)
        telaCarrinho.putExtra("quantidade", quantidade.text.toString().toInt())
        startActivity(telaCarrinho)
    }

    fun irTelaAnterior(view: View) {
        val telaProduto = Intent(this, ProdutoPetshop::class.java)
        startActivity(telaProduto)
    }
}