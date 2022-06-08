package com.example.ipet

import API.ApiIpet
import Adapter.AdapterPedido
import Model.*
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import home.Home
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
        var nomeUsuario = dadosUsuario?.getString("nomeUsuario")


        val telaHome = Intent(this, Home::class.java)
        telaHome.putExtra("idUsuario", idUsuario)
        telaHome.putExtra("nomeUsuario", nomeUsuario)

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

                        if (usuario.idUsuario == idUsuario) {
                            val pedido1 = PedidosModel(Pedido.idPedido, Pedido.pagamento, Pedido.valorTotal, Pedido.status)
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
                Toast.makeText(baseContext, "Erro", Toast.LENGTH_SHORT).show()
            }

        })
    }
    fun clickbtn(pedido: PedidosModel) {

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