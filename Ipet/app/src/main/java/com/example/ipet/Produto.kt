package com.example.ipet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.squareup.picasso.Picasso
import home.Home

class Produto: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        val dadosProduto = intent.extras
        var nomeProduto = dadosProduto?.getString("nomeProduto")
        var descricao = dadosProduto?.getString("descricao")
        var valor = dadosProduto?.getDouble("valor")
        var especie = dadosProduto?.getString("especie")

        var idPetshop = dadosProduto?.getInt("idPetshop")
        var idProduto = dadosProduto?.getInt("idProduto")


        val tv_nomeProduto = findViewById<TextView>(R.id.tv_nome_produto)
        tv_nomeProduto.text = nomeProduto

        val img_foto = findViewById<ImageView>(R.id.iv_imagem_produto)
        Picasso.get().load(especie).into(img_foto)

        val tv_descProduto = findViewById<TextView>(R.id.tv_desc_produto)
        tv_descProduto.text = descricao

        val tv_preco_produto = findViewById<TextView>(R.id.tv_preco_produto)
        tv_preco_produto.text = "$valor"
    }

    fun adicionarProduto(view: View) {
        val quantidade = findViewById<TextView>(R.id.tv_quantidade_produto)
        val valorProduto = findViewById<TextView>(R.id.tv_preco_produto)
        val qtd = Integer.parseInt(quantidade.text.toString()) + 1
        quantidade.text = qtd.toString()
        val dadosProduto = intent.extras
        var preco = dadosProduto?.getDouble("valor")
        var somaValorTotal = preco.toString().toDouble() * quantidade.text.toString().toDouble()
        valorProduto.text = "$somaValorTotal"
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
        var preco = dadosProduto?.getDouble("valor")
        var somaValorTotal = preco.toString().toDouble() * quantidade.text.toString().toDouble()
        valorProduto.text = "$somaValorTotal"
    }

    fun irTelaCarrinho(v: View) {
        val dadosUsuario = intent.extras
        var idUsuario = dadosUsuario?.getInt("idUsuario")
        var nomeUsuario = dadosUsuario?.getString("nomeUsuario")
        val telaCarrinho = Intent(this, Carrinho::class.java)
        val quantidade = findViewById<TextView>(R.id.tv_quantidade_produto)
        val dadosProduto = intent.extras

        var nomeProduto = dadosProduto?.getString("nomeProduto")
        var valor = dadosProduto?.getDouble("valor")
        var descricao = dadosProduto?.getString("descricao")
        var idPetshop = dadosProduto?.getInt("idpet")
        var idProduto = dadosProduto?.getInt("idProduto")
        var especie = dadosProduto?.getString("especie")
        telaCarrinho.putExtra("nomeUsuario",nomeUsuario)
        telaCarrinho.putExtra("idUsuario", idUsuario)
        telaCarrinho.putExtra("nomeProduto", nomeProduto)
        telaCarrinho.putExtra("valor", valor)
        telaCarrinho.putExtra("descricao", descricao)
        telaCarrinho.putExtra("idpet", idPetshop)
        telaCarrinho.putExtra("idProduto", idProduto)
        telaCarrinho.putExtra("especie", especie)
        telaCarrinho.putExtra("quantidade", quantidade.text.toString().toInt())
        startActivity(telaCarrinho)
    }

    fun irTelaAnterior(view: View) {
        val telaProduto = Intent(this, ProdutoPetshop::class.java)
        startActivity(telaProduto)
    }
    fun irTelaPetshops(view: View) {
        val dadosUsuario = intent.extras
        var idUsuario = dadosUsuario?.getInt("idUsuario")
        var nomeUsuario = dadosUsuario?.getString("nomeUsuario")
        val telaPetshop = Intent(this, PetShop::class.java)
        telaPetshop.putExtra("idUsuario", idUsuario)
        telaPetshop.putExtra("nomeUsuario", nomeUsuario)
        startActivity(telaPetshop)

    }
    fun irTelaHome(view: View){
        val dadosUsuario = intent.extras
        var idUsuario = dadosUsuario?.getInt("idUsuario")
        var nomeUsuario = dadosUsuario?.getString("nomeUsuario")
        val telaHome = Intent(this, Home::class.java)
        telaHome.putExtra("idUsuario", idUsuario)
        telaHome.putExtra("nomeUsuario", nomeUsuario)
        startActivity(telaHome)
    }

    override fun onBackPressed() {
        // não chame o super desse método
    }

    fun irTelaPedidos(view: View) {
        val dadosUsuario = intent.extras
        var idUsuario = dadosUsuario?.getInt("idUsuario")
        var nomeUsuario = dadosUsuario?.getString("nomeUsuario")
        val telaPedidos = Intent(this, Pedidos::class.java)
        telaPedidos.putExtra("idUsuario", idUsuario)
        telaPedidos.putExtra("nomeUsuario", nomeUsuario)
        startActivity(telaPedidos)
    }

}