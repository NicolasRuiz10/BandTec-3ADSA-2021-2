package com.example.ipet

import API.ApiIpet
import Adapter.AdapterProdutos
import Model.ProdutosModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProdutoPetshop : AppCompatActivity() {

    val listaProdutoPetshop: MutableList<ProdutosModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto_petshop)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        getConfiguracaoAdapter()

        val dadosPetshop = intent.extras
        var nomePetshop = dadosPetshop?.getString("nomePet")
        var imagemPetshop = dadosPetshop?.getInt("fotoPet")
        var kmPetshop = dadosPetshop?.getString("cnpj")
        var telPetshop = dadosPetshop?.getInt("telefone")
        var idPetshop = dadosPetshop?.getInt("idPetshop")
        var emailPetshop = dadosPetshop?.getInt("email")



        val titlePetshop = findViewById<TextView>(R.id.tv_nome_petshop_produtos)
        titlePetshop.setText(nomePetshop)

        val TvkmPetshop = findViewById<TextView>(R.id.tv_km_pet)
        TvkmPetshop.setText(kmPetshop)

        val TvTelPetshop = findViewById<TextView>(R.id.tv_telefone_pet)
        TvTelPetshop.setText("(11) ${telPetshop.toString()}")

        val imagemPet = findViewById<ImageView>(R.id.iv_imagem_petshop)
        imagemPet.setImageResource(imagemPetshop!!)


        val recyclerView_produtos_petshop = findViewById<RecyclerView>(R.id.rc_produtos_petshop)
        recyclerView_produtos_petshop.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_produtos_petshop.setHasFixedSize(true)


        val getProdutos = ApiIpet.criar().getProdutos()
        getProdutos.enqueue(object : Callback<List<ProdutosModel>> {
            val dadosPetshop = intent.extras
            var idPetshop = dadosPetshop?.getInt("idPetshop")


            override fun onResponse(call: Call<List<ProdutosModel>>, response: Response<List<ProdutosModel>>) {
                if (response.isSuccessful) {
                    Toast.makeText(baseContext, "ENTROU", Toast.LENGTH_SHORT).show()
                    response.body()?.forEach { produto ->
                        println("ID1."+ produto.idPet)
                        println("ID2."+ idPetshop)
                        if (produto.idPet == idPetshop) {
                            println("ENTROU PORRA")
                            listaProdutoPetshop.add(ProdutosModel(produto.idProduto, produto.nome, produto.idPet, produto.descricao, produto.valor))
                        }
                    }
                    val adapterProduto = AdapterProdutos(baseContext, listaProdutoPetshop)
                        adapterProduto.onClickListener = { produto ->
                            clickbtn(produto)
                        }
                    recyclerView_produtos_petshop.adapter = adapterProduto




//                    response.body()?.forEach { produto ->
//                        println("LISTA."+produto)
//                        listaProdutoPetshop.add(ProdutosModel(produto.nome))
//                        println("LISTAAAA"+listaProdutoPetshop)
//
//
//                    }
                }
            }
            override fun onFailure(call: Call<List<ProdutosModel>>, t: Throwable) {
                Toast.makeText(baseContext, "NÂO ENTROU OTARIO", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getConfiguracaoAdapter() {


        itensListaProdutos()
    }

    private fun itensListaProdutos() {
//        val p1 = ProdutosModel(
//            1,
//            "Ração GranPlus Menu Frango e Arroz para Cães Adultos",
//            "- Manutenção da massa muscular, com fontes nobres de proteína;\n" +
//                    "- Ótimo equilíbrio intestinal, com polpa de beterraba e prebiótico MOS GranPlus",
//            199.00,
//            1,
//        )
//
//        listaProdutoPetshop.add(p1)
    }

    private fun clickbtn(produtos: ProdutosModel) {
        val telaProdutoDatalhe = Intent(this, Produto::class.java)
        telaProdutoDatalhe.putExtra("idProduto", produtos.idProduto)
        telaProdutoDatalhe.putExtra("nomeProduto", produtos.nome)
        telaProdutoDatalhe.putExtra("valor", produtos.valor)
        telaProdutoDatalhe.putExtra("descricao", produtos.descricao)
        telaProdutoDatalhe.putExtra("idpet", produtos.idPet)
        startActivity(telaProdutoDatalhe)
    }
}