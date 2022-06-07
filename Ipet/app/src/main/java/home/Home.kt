package home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cadastro.Cadastro
import com.example.ipet.PetShop
import com.example.ipet.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }


    private fun setupViews(){
        val tabLayout = binding.addTab
        val viewPage = binding.addViewpager
        val adapter = TabViewPageAdapter(this)
        viewPage.adapter = adapter

        TabLayoutMediator(tabLayout,viewPage) { tab, position ->
            tab.text = adapter.tabs[position]
        }.attach()
    }

    fun irTelaPetshops(view: View) {
        val telaPetshop = Intent(this, PetShop::class.java)
        startActivity(telaPetshop)

    }

}

    class TabViewPageAdapter(fa:FragmentActivity) : FragmentStateAdapter(fa){

        val tabs = arrayOf("PetShops")
        val fragments = arrayOf(Ipet())

        override fun getItemCount() =fragments.size

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }
    }


