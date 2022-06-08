package Adapter

import Model.PedidosModel
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ipet.databinding.PedidosItemBinding
import com.squareup.picasso.Picasso

class AdapterPedido(
    private val context: Context,
    private val pedidoList: MutableList<PedidosModel>,
    var onClickListener: (pedido: PedidosModel) -> Unit = {}
): RecyclerView.Adapter<AdapterPedido.PedidoViewHolder>() {
    //  Responsavel por criar as visualizações
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidoViewHolder =
        PedidoViewHolder.from(parent)

    //  Responsavel exibir as visualizações em tela
    override fun onBindViewHolder(holder: PedidoViewHolder, position: Int) {
        val item = pedidoList[position]
        holder.bind(item, onClickListener)
    }

    override fun getItemCount(): Int = pedidoList.size

    class PedidoViewHolder(val biding: PedidosItemBinding) : RecyclerView.ViewHolder(biding.root) {
        fun bind(item: PedidosModel, onClickListener: (pedido: PedidosModel) -> Unit) {
            with(biding) {
                idPedido.text = ("Id pedido: "+item.idPedido.toString())
                pagamento.text = "Pagamento: "+item.pagamento
                valorTotal.text = "Valor: R$"+item.valorTotal.toString()
                status.text = "Status: "+item.status
                llItemPedido.setOnClickListener{
                    onClickListener(item)
                }
            }
        }
        companion object {
            fun from(parent: ViewGroup) : PedidoViewHolder {
                val biding: PedidosItemBinding = PedidosItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return PedidoViewHolder(biding)
            }
        }

    }
}
