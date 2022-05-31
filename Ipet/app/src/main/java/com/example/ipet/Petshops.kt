package com.example.ipet

import API.ApiIpet
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import cadastro.Cadastro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Petshops : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_petshops)
        listartPeshop()
    }
    var idPetshopGlobal = ""
    fun listartPeshop() {
        val getPetshops = ApiIpet.criar().getPetshop()

        getPetshops.enqueue(object : Callback<List<Petshop>> {
            override fun onResponse(call: Call<List<Petshop>>, response: Response<List<Petshop>>) {
                val petshops = findViewById<LinearLayout>(R.id.ll_linha_petshop)
                petshops.removeAllViews()


                if (response.isSuccessful) {
                    val transaction = supportFragmentManager.beginTransaction()
                    response.body()?.forEach { petshop ->
                        val argumentos = Bundle()
                        val fragmento = FragmentContainerView(baseContext)
                        fragmento.id = View.generateViewId()
                        petshops.addView(fragmento)
                        argumentos.putString("nome", petshop.nome)
                        argumentos.putString("idPetshop", petshop.idPetshop.toString())
                        argumentos.putString("enderecoImagem", getString(R.string.imagem_cobasi))
                        transaction.add(fragmento.id, LinhaPetshop::class.java, argumentos)
                        idPetshopGlobal = petshop.idPetshop.toString()
                    }
                    transaction.commit()
                } else {
                    Toast.makeText(baseContext, "Sem petshops", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Petshop>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(baseContext, "Erro na api", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun irTelaProutosPetshop(v: View) {
        val telaProdutosPetshop = Intent(this, ProdutosPetshop::class.java)
        telaProdutosPetshop.putExtra("idPetshop", idPetshopGlobal)
        startActivity(telaProdutosPetshop)
    }
}