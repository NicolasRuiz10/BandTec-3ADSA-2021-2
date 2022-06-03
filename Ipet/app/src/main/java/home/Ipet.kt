package home

import API.ApiIpet
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.ipet.Petshop
import com.example.ipet.R
import com.example.ipet.databinding.FragmentIpetBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


class Ipet : Fragment(R.layout.fragment_ipet) {

    private var binding: FragmentIpetBinding? = null

    private val categoryAdapter = ATAdapter({ CategoryView(it) })
    private val bannerAdapter = ATAdapter({ BannerView(it) })
    private val moreShopAdapter = ATAdapter({ MoreShopView(it)})

 /*   private var filters = arrayOf(
        FilterItem(1,"Ordenar", closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
        FilterItem(2,"Pra retirar", icon = R.drawable.ic_baseline_directions_walk_24),
        FilterItem(3,"Entrega Gratis"),
        FilterItem(4,"Vale-Refeição", closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
        FilterItem(5,"Distancia", closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
        FilterItem(6,"Entrega Parceira"),
        FilterItem(7,"Super restaurante"),
        FilterItem(8,"Filtros")
    )
*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryAdapter.items = arrayListOf(
            Category(1, "https://static-images.ifood.com.br/image/upload/t_high/pratos/5fd95808-15cb-4b3d-9a86-a53357d66c73/20220425160110_353638.jpg","Ração", 0xFFB6D048),
            Category(2, "https://static-images.ifood.com.br/image/upload/t_high/pratos/5fd95808-15cb-4b3d-9a86-a53357d66c73/20211008083523_244490.jpg","Petiscos", 0xFFE6D553),
            Category(3, "https://www.petlove.com.br/images/products/251760/small/Bowl_Future_Pet_para_C%C3%A3es_e_Gatos_-_1100_mL_2765008_%281%29.jpg?1642454448","Acessórios", 0xFFB6D048),
            Category(4, "https://static-images.ifood.com.br/image/upload/t_high/pratos/5fd95808-15cb-4b3d-9a86-a53357d66c73/20220411191046_1343710.jpg","Brinquedos", 0xFFE6D553),
            Category(5, "https://static-images.ifood.com.br/image/upload/t_high/pratos/5fd95808-15cb-4b3d-9a86-a53357d66c73/20220511202203_996442.jpg","Higiene", 0xFFB6D048),
        )

        bannerAdapter.items = arrayListOf(
            Banner(1,"https://static-images.ifood.com.br/image/upload/t_high/discoveries/paraseugato1_K0dN.png","Para Seu Gato"),
            Banner(2,"https://static-images.ifood.com.br/image/upload/t_high/discoveries/paraseucachorro2_q2F3.png","Para Seu Cão"),
        )



     moreShopAdapter.items = arrayListOf(
         MoreShop(1,"https://static-images.ifood.com.br/image/upload/t_thumbnail/logosgde/1536640b-aa6e-4eea-88c1-919ca21b89fe/202202021101_JzhS_.jpeg","Formosão Pet Shop","Pets",5.0,"20-30",3.0))


     val getPetshops = ApiIpet.criar().getPetshop()
     getPetshops.enqueue(object : Callback<List<Petshop>> {
         override fun onResponse(call: Call<List<Petshop>>, response: Response<List<Petshop>>) {
             if (response.isSuccessful) {
                 response.body()?.forEach { petshop ->
                     moreShopAdapter.items.add(MoreShop(petshop.idPetshop,"https://miro.medium.com/max/640/0*i1v1In2Tn4Stnwnl.jpg",petshop.nome,"Pets",5.0,"20-30",3.0))

                 }

             }
         }
         override fun onFailure(call: Call<List<Petshop>>, t: Throwable) {
         }
     })


        binding = FragmentIpetBinding.bind(view)

        binding?.let {
            it.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvCategory.adapter = categoryAdapter

            it.rvBanners.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvBanners.adapter = bannerAdapter

            it.rvMoreShops.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            it.rvMoreShops.adapter = moreShopAdapter

            it.rvBanners.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrollStateChanged (recyclerView: RecyclerView, newState : Int){
                    if ( newState == RecyclerView.SCROLL_STATE_IDLE){
                       notifyPositionChanged(recyclerView)
                    }
                }
            })
            addDots(it.dots, bannerAdapter.items.size, 0)


        }


 }
    private fun addDots(container: LinearLayout, size:Int, position : Int){
        container.removeAllViews()

        Array(size){
            val textView = TextView(context).apply{
                text = getString(R.string.dotted)
                textSize = 20f
                setTextColor(
                    if(position == it) ContextCompat.getColor(context, android.R.color.black)
                    else ContextCompat.getColor(context, android.R.color.darker_gray)
                )
            }
            container.addView(textView)
        }
    }

    private var position : Int? = RecyclerView.NO_POSITION
    private val snapHelper = LinearSnapHelper()

    private fun notifyPositionChanged (recyclerView: RecyclerView){
        val layoutManager  = recyclerView.layoutManager
        val view = snapHelper.findSnapView(layoutManager)
        val position = if ( view == null) RecyclerView.NO_POSITION else layoutManager?.getPosition(view)

        val positionChanged = this.position != position
        if(positionChanged){
            addDots(binding!!.dots, bannerAdapter.items.size, position?: 0)
        }
        this.position = position

    }
}


