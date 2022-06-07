package Adapter

import Model.PetShopModel
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ipet.databinding.PetshopItemBinding

class AdapterPetshop  (private val context: Context,
                       private val petshopList: MutableList<PetShopModel>,
                       var onClickListener: (petshop: PetShopModel) -> Unit = {}
): RecyclerView.Adapter<AdapterPetshop.PetshopViewHolder>() {

    //  Responsavel por criar as visualizações
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPetshop.PetshopViewHolder = AdapterPetshop.PetshopViewHolder.from(parent)

    //  Responsavel exibir as visualizações em tela
    override fun onBindViewHolder(holder: AdapterPetshop.PetshopViewHolder, position: Int) {
        val item = petshopList[position]
        holder.bind(item, onClickListener)
    }

    override fun getItemCount() = petshopList.size


    class PetshopViewHolder(val biding: PetshopItemBinding) : RecyclerView.ViewHolder(biding.root) {
        fun bind(item: PetShopModel, onClickListener: (petshop: PetShopModel) -> Unit) {
            with(biding) {
                nomePetshop.text = item.nome
                emailPetshop.text = item.email
                numeroPetshop.text = item.telefone
                idPet.text = item.idPetshop.toString()
                llItemPetshop.setOnClickListener{
                    onClickListener(item)
                }
            }
        }
        companion object {
            fun from(parent: ViewGroup) : PetshopViewHolder {
                val biding: PetshopItemBinding = PetshopItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return PetshopViewHolder(biding)
            }
        }

    }




}