package home

import android.view.ViewGroup
import com.example.ipet.databinding.ShopItemBinding
import com.squareup.picasso.Picasso

class ShopView(viewGroup: ViewGroup): ATViewHolder<Shop, ShopItemBinding>(
    ShopItemBinding::inflate,
    viewGroup
) {

    override fun bind(item: Shop) {
        Picasso.get()
            .load(item.bannerUrl)
            .into(binding.imgShop)

        binding.txtShop.text= item.text

    }
}
