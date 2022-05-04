package com.example.ipet

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginLeft
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Petshops : AppCompatActivity() {
    lateinit var llPetshop: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_petshops)
        llPetshop = findViewById(R.id.ll_petshop)
        listartFilmes()
    }
    fun listartFilmes() {
        val getPetshops = ApiIpet.criar().getPetshop()

        getPetshops.enqueue(object : Callback<List<Petshop>> {
            override fun onResponse(call: Call<List<Petshop>>, response: Response<List<Petshop>>) {
                if (response.isSuccessful) {
                    llPetshop.removeAllViews()
                    response.body()?.forEach { petshop ->
                        val tvPetshop: TextView = TextView(baseContext)
                        val imPetshop: ImageView = ImageView(baseContext)
//                        imPetshop.setImageResource(R.mipmap.petx)
                        imPetshop.setImageResource(R.drawable.search_icon_foreground)
                        imPetshop.setPadding(10, 10, 10, 10)
                        tvPetshop.text = "${petshop?.nome}"
                        tvPetshop.setTextColor(Color.BLACK)
                        tvPetshop.setTextSize(20F)
                        llPetshop.addView(tvPetshop)
                    }
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
}