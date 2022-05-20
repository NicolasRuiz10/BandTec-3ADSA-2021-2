package home

import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.ipet.R
import com.example.ipet.databinding.ActivityCadastroBinding.inflate
import com.example.ipet.databinding.MoreShopBinding
import com.example.ipet.databinding.ShopItemBinding
import com.squareup.picasso.Picasso

    class MoreShopView(viewGroup: ViewGroup): ATViewHolder<MoreShop, MoreShopBinding>(
    MoreShopBinding::inflate,
    viewGroup
) {

    override fun bind(item: MoreShop) {
        Picasso.get()
            .load(item.bannerUrl)
            .into(binding.imgShop)

        binding.txtShop.text= item.text
        binding.txtSubtitle.text = itemView.context.getString(R.string.shop_category, item.category, item.distance)
        binding.txtPrice.text = itemView.context.getString(R.string.shop_price, item.time, item.price)

    }


}
