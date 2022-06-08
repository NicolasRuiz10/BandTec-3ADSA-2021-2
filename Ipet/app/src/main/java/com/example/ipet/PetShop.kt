package com.example.ipet

import API.ApiIpet
import Adapter.AdapterPetshop
import Model.PetShopModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import home.Home
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PetShop : AppCompatActivity() {
    val listaPetshops: MutableList<PetShopModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_shop)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);



        val recyclerView_petshop = findViewById<RecyclerView>(R.id.lista_petshops)

        recyclerView_petshop.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_petshop.setHasFixedSize(true)


        val getPetshops = ApiIpet.criar().getPetshop()
        getPetshops.enqueue(object : Callback<List<PetShopModel>> {
            override fun onResponse(call: Call<List<PetShopModel>>, response: Response<List<PetShopModel>>) {
                if (response.isSuccessful) {
                    response.body()?.forEach { petshop ->

                        listaPetshops.add(PetShopModel(petshop.idPetshop, petshop.nome, petshop.cnpj, petshop.telefone, petshop.email,petshop.complemento))
                        println("URL "+ petshop.complemento)
                        val adapterPet = AdapterPetshop(baseContext, listaPetshops)
                        adapterPet.onClickListener = { pet ->
                            clickbtn(pet)
                        }
                        recyclerView_petshop.adapter = adapterPet
                    }

                }
            }
            override fun onFailure(call: Call<List<PetShopModel>>, t: Throwable) {
                Toast.makeText(baseContext, "Erro AQUI ?", Toast.LENGTH_SHORT).show()
            }
        })


    }

    private fun clickbtn(petshop: PetShopModel) {
        val dadosUsuario = intent.extras
        var idUsuario = dadosUsuario?.getInt("idUsuario")
        var nomeUsuario = dadosUsuario?.getString("nomeUsuario")
        val telaProdutosPetshop = Intent(this, ProdutoPetshop::class.java)
        telaProdutosPetshop.putExtra("idUsuario", idUsuario)
        telaProdutosPetshop.putExtra("nomeUsuario", nomeUsuario)
        telaProdutosPetshop.putExtra("idPetshop", petshop.idPetshop)
        telaProdutosPetshop.putExtra("nomePet", petshop.nome)
        telaProdutosPetshop.putExtra("cnpj", petshop.cnpj)
        telaProdutosPetshop.putExtra("telefone", petshop.telefone)
        telaProdutosPetshop.putExtra("email", petshop.email)
        telaProdutosPetshop.putExtra("fotoPet", R.drawable.petlove)
        telaProdutosPetshop.putExtra("complemento", petshop.complemento)
        startActivity(telaProdutosPetshop)
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

    fun irTelaPetshops(view: View) {
        val dadosUsuario = intent.extras
        var idUsuario = dadosUsuario?.getInt("idUsuario")
        var nomeUsuario = dadosUsuario?.getString("nomeUsuario")
        val telaPetshop = Intent(this, PetShop::class.java)
        telaPetshop.putExtra("idUsuario", idUsuario)
        telaPetshop.putExtra("nomeUsuario", nomeUsuario)
        startActivity(telaPetshop)

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





