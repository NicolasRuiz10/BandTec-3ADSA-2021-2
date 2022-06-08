package com.example.ipet

import API.ApiIpet
import Adapter.AdapterPedido
import Model.*
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pedidos : AppCompatActivity()  {
    val listaPedidoAberto: MutableList<PedidosModel> = mutableListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        val dadosUsuario = intent.extras
        var idUsuario = dadosUsuario?.getInt("idUsuario")

        val recyclerView_pedidos_abertos = findViewById<RecyclerView>(R.id.lista_pedidos)

        recyclerView_pedidos_abertos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_pedidos_abertos.setHasFixedSize(true)


        val getPedidos = ApiIpet.criar().getItem()
        getPedidos.enqueue(object : Callback<List<PedidoRealizado>>{
            override fun onResponse(
                call: Call<List<PedidoRealizado>>,
                response: Response<List<PedidoRealizado>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.forEach{ pedido ->
                        val usuario = Usuario(pedido.pedido.fkUsuario.idUsuario, pedido.pedido.fkUsuario.nome, pedido.pedido.fkUsuario.email, pedido.pedido.fkUsuario.senha)
                        val Pedido = PedidoModel(pedido.pedido.idPedido, pedido.pedido.pagamento, pedido.pedido.valorTotal, pedido.pedido.status, usuario)
                        val Produto = ProdutosModel(pedido.produto.idProduto, pedido.produto.nome, pedido.produto.idPet, pedido.produto.descricao, pedido.produto.valor)
                        println("PEDIDO VINDO 1"+ pedido)
                        println("USUARIO VINDO"+ usuario.idUsuario)
                        println("PRODUTO VINDO"+ Produto.idProduto)
                        println("PEDIDO VINDO"+ Pedido.idPedido)
                        if (usuario.idUsuario == idUsuario) {
                            val pedido1 = PedidosModel(Pedido.idPedido, Pedido.pagamento, Pedido.valorTotal, Pedido.status)
                            println("ID PEDIDO VINDO"+ Pedido.idPedido)
                                listaPedidoAberto.add(pedido1)
                                val adapterPedidoAberto = AdapterPedido(baseContext, listaPedidoAberto)
                                adapterPedidoAberto.onClickListener = { pedido ->
                                    clickbtn(pedido)
                                }
                                recyclerView_pedidos_abertos.adapter = adapterPedidoAberto
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<PedidoRealizado>>, t: Throwable) {
                Toast.makeText(baseContext, "NÂO LISTOU OTARIO", Toast.LENGTH_SHORT).show()
            }

        })
    }
    fun clickbtn(pedido: PedidosModel) {
        println("Cliquei aqui"+ pedido.toString())
    }
}