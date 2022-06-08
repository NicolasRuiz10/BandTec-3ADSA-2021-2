package Model

import com.example.ipet.Usuario

data class PedidoModel(
    val idPedido: Int,
    val pagamento: String,
    val valorTotal: Double,
    val status: String,
    val fkUsuario: Usuario
)
{
}