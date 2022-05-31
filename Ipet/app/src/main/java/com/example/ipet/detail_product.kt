package com.example.ipet

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class detail_product : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tvNome: TextView = view.findViewById(R.id.tv_nome)
        val tvValor: TextView = view.findViewById(R.id.tv_valor)
        val nome = arguments?.getString("nome")
        val valor = arguments?.getDouble("valor")
        tvNome.text = nome
        tvValor.text = valor.toString()

        // Picasso.with(view.context).load(endereco).into(ivPetShop)
    }
}