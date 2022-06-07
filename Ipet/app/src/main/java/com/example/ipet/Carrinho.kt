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
        val telaPedidos = Intent(this, Home::class.java)
        val dadosProduto = intent.extras
        var valor = dadosProduto?.getInt("valor")
        var idProduto = dadosProduto?.getInt("idProduto")
        var quantidade = dadosProduto?.getInt("quantidade")
        var valorTotal = valor.toString().toInt() * quantidade.toString().toInt()

        val novoPedido = PedidosModel(99, "teste2HBMJBJBBJJU22UUddd", valorTotal.toDouble(), "aberto")
        val postPedido = ApiIpet.criar().postPedidos(novoPedido, 1)
        postPedido.enqueue(object : Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                val getPedidos = ApiIpet.criar().getPedido()
                getPedidos.enqueue(object : Callback<List<PedidosModel>>{
                    override fun onResponse(
                        call: Call<List<PedidosModel>>,
                        response: Response<List<PedidosModel>>
                    ) {
                        if (response.isSuccessful) {
                            println("Entrou sucesso")
                            response.body()?.forEach { pedido ->
                                println("STATUS1"+ pedido.status)
                                println("STATUS2"+ novoPedido.status)
                                println("PAG1"+ pedido.pagamento)
                                println("PAG2"+ novoPedido.pagamento)
                                if (
                                    pedido.status == novoPedido.status &&
                                    pedido.pagamento == novoPedido.pagamento
                                ) {
                                    println("Entrou if")
                                    val pedidoRealizado = PedidosModel(pedido.idPedido, pedido.pagamento, pedido.valorTotal, pedido.status)
                                    val itemPedido = ItensPedidos(quantidade)
                                    println("pedido realizado"+ pedidoRealizado.idPedido)
                                    val itensPedidos = ApiIpet.criar().postItensPedidos(itemPedido, pedido.idPedido, idProduto)
                                    itensPedidos.enqueue(object : Callback<Void> {
                                        override fun onResponse(call: Call<Void>, response: Response<Void>) {
                                            Toast.makeText(baseContext, "Pedido Realizado", Toast.LENGTH_SHORT).show()
                                            startActivity(telaPedidos)
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