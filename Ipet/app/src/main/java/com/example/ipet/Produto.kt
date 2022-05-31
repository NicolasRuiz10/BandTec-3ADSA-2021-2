package com.example.ipet

class Produto (
    val idProduto: Int,
    val nome: String,
    val descricao: String,
    val valor: Double,
    val marca: String,
    val especie: String,
    val quantidade: Int,
    val fkPetshop: Int,
) {
}