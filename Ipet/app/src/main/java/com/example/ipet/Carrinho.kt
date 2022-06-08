package com.example.ipet

import API.ApiIpet
import Adapter.AdapterProdutos
import Model.ItensPedidos
import Model.PedidosModel
import Model.ProdutosModel
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import home.Home
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Carrinho: AppCompatActivity() {
    val listaPedidos: MutableList<PedidosModel> = mutableListOf()

    val listaProdutosCarrinho: MutableList<ProdutosModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)

        val recyclerView_produtosCarrinho = findViewById<RecyclerView>(R.id.rv_produtos_carriho)

        val dadosProduto = intent.extras
        var nomeProduto = dadosProduto?.getString("nomeProduto")
        var valor = dadosProduto?.getInt("valor")
        var descricao = dadosProduto?.getString("descricao")
        var idPetshop = dadosProduto?.getInt("idPetshop")
        var idProduto = dadosProduto?.getInt("idProduto")
        var quantidade = dadosProduto?.getInt("quantidade")

        println("Qtd"+ quantidade)
        println("Valor"+ valor)
        var valorTotal = valor.toString().toInt() * quantidade.toString().toInt()

        var p1 = ProdutosModel(idProduto, nomeProduto, idPetshop, descricao,valorTotal)
        listaProdutosCarrinho.add(p1)
        recyclerView_produtosCarrinho.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_produtosCarrinho.setHasFixedSize(true)
        val adapterProduto = AdapterProdutos(this, listaProdutosCarrinho)
        adapterProduto.onClickListener = { produto ->
            clickbtn(produto)
        }
        recyclerView_produtosCarrinho.adapter = adapterProduto

    }
    fun irTelaProdutos(view: View) {
        val telaProdutos = Intent(this, ProdutoPetshop::class.java)
        Toast.makeText(baseContext, "Compra realizada com sucesso", Toast.LENGTH_SHORT).show()
        startActivity(telaProdutos)
    }
    fun irTelaPedidos(view: View) {

        val telaPedidos = Intent(this, Pedidos::class.java)
        val dadosProduto = intent.extras
        var valor = dadosProduto?.getInt("valor")
        var idProduto = dadosProduto?.getInt("idProduto")
        var quantidade = dadosProduto?.getInt("quantidade")
        var valorTotal = valor.toString().toInt() * quantidade.toString().toInt()

        val dadosUsuario = intent.extras
        var idUsuario = dadosUsuario?.getInt("idUsuario")


//        var nomeUsuario = dadosUsuario?.getString("nomeUsuario")
//        var emailUsuario = dadosUsuario?.getString("emailUsuario")
//        var senhaUsuario = dadosUsuario?.getString("senhaUsuario")

        val novoPedido = PedidosModel(350, "teste", valorTotal.toDouble(), "aberto")
        val postPedido = ApiIpet.criar().postPedidos(novoPedido, idUsuario.toString().toInt())
        postPedido.enqueue(object : Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                val getPedidos = ApiIpet.criar().getPedido()
                getPedidos.enqueue(object : Callback<List<PedidosModel>>{
                    override fun onResponse(
                        call: Call<List<PedidosModel>>,
                        response: Response<List<PedidosModel>>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.forEach { pedido ->
                                if (
                                    pedido.status.equals(novoPedido.status, ignoreCase = true) &&
                                    pedido.pagamento.equals(novoPedido.pagamento, ignoreCase = true)
                                ) {
                                    val pedidoRealizado = PedidosModel(pedido.idPedido, pedido.pagamento, pedido.valorTotal, pedido.status)
                                    val itemPedido = ItensPedidos(quantidade)
                                    val itensPedidos = ApiIpet.criar().postItensPedidos(itemPedido, pedido.idPedido, idProduto)
                                    itensPedidos.enqueue(object : Callback<Void> {
                                        override fun onResponse(call: Call<Void>, response: Response<Void>) {
                                            telaPedidos.putExtra("idUsuario", idUsuario)
                                            startActivity(telaPedidos)
                                            Toast.makeText(baseContext, "Pedido Realizado", Toast.LENGTH_SHORT).show()
                                        }
                                        override fun onFailure(call: Call<Void>, t: Throwable) {
                                            Toast.makeText(baseContext, "Erro na API 2", Toast.LENGTH_SHORT).show()
                                        }
                                    })
                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<PedidosModel>>, t: Throwable) {
                        Toast.makeText(baseContext, "Erro na API 3", Toast.LENGTH_SHORT).show()
                    }

                } )
            }
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na API", Toast.LENGTH_SHORT).show()
            }
        })


    }


    private fun clickbtn(produtos: ProdutosModel) {

    }
}