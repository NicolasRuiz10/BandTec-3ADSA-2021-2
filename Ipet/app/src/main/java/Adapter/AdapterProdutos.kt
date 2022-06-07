package Adapter

import Model.ProdutosModel
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ipet.databinding.ProdutoItemBinding

class AdapterProdutos (private val context: Context,
                       private val ProdutosList: MutableList<ProdutosModel>,
                       var onClickListener: (produtos: ProdutosModel) -> Unit = {}
): RecyclerView.Adapter<AdapterProdutos.ProdutosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterProdutos.ProdutosViewHolder = AdapterProdutos.ProdutosViewHolder.from(parent)


    //  Responsavel exibir as visualizações em tela
    override fun onBindViewHolder(holder: AdapterProdutos.ProdutosViewHolder, position: Int) {
        val item = ProdutosList[position]
        holder.bind(item, onClickListener)
    }
    override fun getItemCount() = ProdutosList.size

    class ProdutosViewHolder(val biding: ProdutoItemBinding) : RecyclerView.ViewHolder(biding.root) {
        fun bind(item: ProdutosModel, onClickListener: (produtos: ProdutosModel) -> Unit) {
            with(biding) {
                nomeProduto.text = item.nome
                precoProduto.text = "199"
                descProduto.text = "teste"
                llItemProdutos.setOnClickListener{
                    onClickListener(item)
                }
            }
        }
        companion object {
            fun from(parent: ViewGroup) : ProdutosViewHolder {
                val biding: ProdutoItemBinding = ProdutoItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ProdutosViewHolder(biding)
            }
        }

    }
}