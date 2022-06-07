package com.example.ipet

import Adapter.AdapterPedido
import Model.PedidosModel
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Pedidos : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //      Recuperando recycleView da Activity
        val recyclerView_pedidos_abertos = findViewById<RecyclerView>(R.id.lista_pedidos_aberto)
        val recyclerView_pedidos_andamento = findViewById<RecyclerView>(R.id.lista_pedidos_andamento)
        val recyclerView_pedidos_finalizados = findViewById<RecyclerView>(R.id.lista_pedidos_finalizado)

        //      Listando Horizontalmente
        recyclerView_pedidos_abertos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //      Melhora o desempenho da RecycleView
        recyclerView_pedidos_abertos.setHasFixedSize(true)
        //     Configurar Adpater
        val listaPedidoAberto: MutableList<PedidosModel> = mutableListOf()
        val adapterPedidoAberto = AdapterPedido(this, listaPedidoAberto)
        adapterPedidoAberto.onClickListener = { pedido ->
            clickbtn(pedido)
        }
        recyclerView_pedidos_abertos.adapter = adapterPedidoAberto




        //      Listando Horizontalmente
        recyclerView_pedidos_andamento.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //      Melhora o desempenho da RecycleView
        recyclerView_pedidos_andamento.setHasFixedSize(true)
        //     Configurar Adpater
        val listaPedidoAndamento: MutableList<PedidosModel> = mutableListOf()
        val adapterPedidoAndamento = AdapterPedido(this, listaPedidoAndamento)
        adapterPedidoAndamento.onClickListener = { pedido ->
            clickbtn(pedido)
        }
        recyclerView_pedidos_andamento.adapter = adapterPedidoAndamento

        //      Listando Horizontalmente
        recyclerView_pedidos_finalizados.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //      Melhora o desempenho da RecycleView
        recyclerView_pedidos_finalizados.setHasFixedSize(true)
//     Configurar Adpater
        val listaPedidoFinalizado: MutableList<PedidosModel> = mutableListOf()
        val adapterProdutoFinalizado = AdapterPedido(this, listaPedidoFinalizado)
        adapterProdutoFinalizado.onClickListener = { pedido ->
            clickbtn(pedido)
        }
        recyclerView_pedidos_finalizados.adapter = adapterProdutoFinalizado

//      Pedidos com status Aberto
        val pedido1 = PedidosModel(
            6,
            "Cartão1",
            120.00,
            "andamento"
        )

        val pedido2 = PedidosModel(
            5,
            "Cartão2",
            120.00,
            "andamento"
        )

        val pedido3 = PedidosModel(
            4,
            "Cartão3",
            120.00,
            "andamento"
        )

        //      Pedidos com status Andamento
        val pedido4 = PedidosModel(
            3,
            "Cartão4",
            120.00,
            "andamento"
        )

        //      Pedidos com status Finalizado
        val pedido5 = PedidosModel(
            2,
            "Cartão5",
            120.00,
            "andamento"
        )
        val pedido6 = PedidosModel(
            1,
            "Cartão6",
            120.00,
            "andamento"
        )


        listaPedidoAberto.add(pedido1)
        listaPedidoAberto.add(pedido2)
        listaPedidoAberto.add(pedido3)
        listaPedidoAndamento.add(pedido4)
        listaPedidoFinalizado.add(pedido5)
        listaPedidoFinalizado.add(pedido6)
    }
    fun irStatusAberto(v: View) {
        //      Recuperando recycleView da Activity
        val recyclerView_pedidos_abertos = findViewById<RecyclerView>(R.id.lista_pedidos_aberto)
        val recyclerView_pedidos_andamento = findViewById<RecyclerView>(R.id.lista_pedidos_andamento)
        val recyclerView_pedidos_finalizados = findViewById<RecyclerView>(R.id.lista_pedidos_finalizado)

        recyclerView_pedidos_abertos.visibility = View.VISIBLE
        recyclerView_pedidos_andamento.visibility = View.INVISIBLE
        recyclerView_pedidos_finalizados.visibility = View.INVISIBLE
    }

    fun irStatusAndamento(v: View) {
        //      Recuperando recycleView da Activity
        val recyclerView_pedidos_abertos = findViewById<RecyclerView>(R.id.lista_pedidos_aberto)
        val recyclerView_pedidos_andamento = findViewById<RecyclerView>(R.id.lista_pedidos_andamento)
        val recyclerView_pedidos_finalizados = findViewById<RecyclerView>(R.id.lista_pedidos_finalizado)

        recyclerView_pedidos_abertos.visibility = View.INVISIBLE
        recyclerView_pedidos_andamento.visibility = View.VISIBLE
        recyclerView_pedidos_finalizados.visibility = View.INVISIBLE
    }

    fun irStatusFinalizado(v: View) {
        //      Recuperando recycleView da Activity
        val recyclerView_pedidos_abertos = findViewById<RecyclerView>(R.id.lista_pedidos_aberto)
        val recyclerView_pedidos_andamento = findViewById<RecyclerView>(R.id.lista_pedidos_andamento)
        val recyclerView_pedidos_finalizados = findViewById<RecyclerView>(R.id.lista_pedidos_finalizado)

        recyclerView_pedidos_abertos.visibility = View.INVISIBLE
        recyclerView_pedidos_andamento.visibility = View.INVISIBLE
        recyclerView_pedidos_finalizados.visibility = View.VISIBLE
    }

    fun clickbtn(pedido: PedidosModel) {
        println("Cliquei aqui"+ pedido.toString())
    }

}