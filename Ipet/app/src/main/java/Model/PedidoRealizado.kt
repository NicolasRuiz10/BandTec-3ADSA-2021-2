package Model

data class PedidoRealizado(
    val id: Int,
    val qtdProduto: Int,
    val produto: ProdutosModel,
    val pedido: PedidoModel,
){}