package com.example.ipet

import API.ApiIpet
import Adapter.AdapterPetshop
import Model.PetShopModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
                    Toast.makeText(baseContext, "ENTROU", Toast.LENGTH_SHORT).show()
                    response.body()?.forEach { petshop ->
                        println("LISTA."+petshop)
                        listaPetshops.add(PetShopModel(petshop.idPetshop, petshop.nome, petshop.cnpj, petshop.telefone, petshop.email))
                        println("LISTAAAA"+listaPetshops)

                        val adapterPet = AdapterPetshop(baseContext, listaPetshops)
                        adapterPet.onClickListener = { pet ->
                            clickbtn(pet)
                        }
                        recyclerView_petshop.adapter = adapterPet
                    }

                }
            }
            override fun onFailure(call: Call<List<PetShopModel>>, t: Throwable) {
                Toast.makeText(baseContext, "NÂO ENTROU OTARIO", Toast.LENGTH_SHORT).show()
            }
        })


    }

    private fun clickbtn(petshop: PetShopModel) {
        val dadosUsuario = intent.extras
        var idUsuario = dadosUsuario?.getInt("idUsuario")
        val telaProdutosPetshop = Intent(this, ProdutoPetshop::class.java)
        telaProdutosPetshop.putExtra("idUsuario", idUsuario)
        telaProdutosPetshop.putExtra("idPetshop", petshop.idPetshop)
        telaProdutosPetshop.putExtra("nomePet", petshop.nome)
        telaProdutosPetshop.putExtra("cnpj", petshop.cnpj)
        telaProdutosPetshop.putExtra("telefone", petshop.telefone)
        telaProdutosPetshop.putExtra("email", petshop.email)
        telaProdutosPetshop.putExtra("fotoPet", R.drawable.petlove)
        startActivity(telaProdutosPetshop)
    }
}





