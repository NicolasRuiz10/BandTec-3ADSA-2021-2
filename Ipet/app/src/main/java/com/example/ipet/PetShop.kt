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


        itensListaPetshop()

        val recyclerView_petshop = findViewById<RecyclerView>(R.id.lista_petshops)

        recyclerView_petshop.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_petshop.setHasFixedSize(true)
        val adapterPet = AdapterPetshop(this, listaPetshops)
        adapterPet.onClickListener = { pet ->
            clickbtn(pet)
        }
        recyclerView_petshop.adapter = adapterPet

        val getPetshops = ApiIpet.criar().getPetshop()
        getPetshops.enqueue(object : Callback<List<PetShopModel>> {
            override fun onResponse(call: Call<List<PetShopModel>>, response: Response<List<PetShopModel>>) {

                if (response.isSuccessful) {

                    Toast.makeText(baseContext, "ENTROU", Toast.LENGTH_SHORT).show()

                    response.body()?.forEach { petshop ->
                        listaPetshops.add(PetShopModel(petshop.idPetshop, petshop.nome,petshop.cnpj))
                        println("LISTAAAA"+listaPetshops)
                    }

                }
            }
            override fun onFailure(call: Call<List<PetShopModel>>, t: Throwable) {
                Toast.makeText(baseContext, "NÂO ENTROU OTARIO", Toast.LENGTH_SHORT).show()
            }
        })


    }

    private fun clickbtn(petshop: PetShopModel) {
        val telaProdutosPetshop = Intent(this, ProdutoPetshop::class.java)
        telaProdutosPetshop.putExtra("nomePet", petshop.nome)
        telaProdutosPetshop.putExtra("idPetshop", petshop.idPetshop)
        startActivity(telaProdutosPetshop)
    }

    private fun itensListaPetshop() {
        println("Entrou aqui")

//        val pet1 = PetshopModel(1, "Cobasi", 955554444, "Aberto", "6 KM", R.drawable.cobasi)
//        val pet2 = PetshopModel(2, "Pets", 999994444, "Aberto", "14 KM", R.drawable.petz)
//        val pet3 = PetshopModel(3, "Petlove", 959994444, "Fechado", "2 KM", R.drawable.petlove)
//        listaPetshops.add(pet1)
//        listaPetshops.add(pet2)
//        listaPetshops.add(pet3)
    }
}





