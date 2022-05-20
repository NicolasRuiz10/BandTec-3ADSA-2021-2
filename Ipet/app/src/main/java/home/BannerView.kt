package home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.example.ipet.databinding.BannerItemBinding
import com.squareup.picasso.Picasso

class BannerView(viewGroup: ViewGroup): ATViewHolder<Banner, BannerItemBinding>(
    BannerItemBinding::inflate,
    viewGroup
) {

    override fun bind(item: Banner) {
        binding.nomeBanner.text= item.texto
        Picasso.get()
            .load(item.bannerUrl)
            .into(binding.imgBanner)

    }
}