package com.example.ipet

import API.ApiIpet
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ipet.databinding.ActivityHomeBinding
import com.example.ipet.databinding.ActivityProdutosPetshopBinding
import com.google.android.material.tabs.TabLayoutMediator
import home.Ipet
import home.TabViewPageAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProdutosPetshop : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtos_petshop)
        listarProdutos()
    }


    var idProdutoGlobal = 0

    fun listarProdutos() {
        val getProdutos = ApiIpet.criar().getProdutosPorPetshops()

        getProdutos.enqueue(object : Callback<List<Produto>> {
            override fun onResponse(call: Call<List<Produto>>, response: Response<List<Produto>>) {
                val produtos = findViewById<LinearLayout>(R.id.ll_produtos)
                produtos.removeAllViews()

                if (response.isSuccessful) {
                    val transaction = supportFragmentManager.beginTransaction()
                    response.body()?.forEach { produto ->
                        val argumentos = Bundle()
                        val fragmento = FragmentContainerView(baseContext)
                        fragmento.id = View.generateViewId()
                        produtos.addView(fragmento)
                        argumentos.putString("nome", produto.nome)
                        argumentos.putString("descrição", produto.descricao)
                        argumentos.putString("marca", produto.marca)
                        argumentos.putString("especie", produto.especie)
                        argumentos.putDouble("valor", produto.valor)
                        argumentos.putInt("quantidade", produto.quantidade)
                        argumentos.putInt("fkPetshop", produto.fkPetshop)
                        argumentos.putString("idProduto", produto.idProduto.toString())
                        transaction.add(fragmento.id, detail_product::class.java, argumentos)
                        idProdutoGlobal = produto.idProduto
                    }
                    transaction.commit()
                } else {
                    Toast.makeText(baseContext, "Sem produtos", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Produto>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(baseContext, "Erro na api", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun irTelaDetalhesProduto(v: View) {
        val telaProdutosPetshop = Intent(this, ProdutosPetshop::class.java)
        telaProdutosPetshop.putExtra("idPetshop", idProdutoGlobal)
        startActivity(telaProdutosPetshop)
    }


}

