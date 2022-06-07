package home

import API.ApiIpet
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cadastro.Cadastro
import cadastro.Login
import com.example.ipet.Pedidos
import com.example.ipet.PetShop
import com.example.ipet.R
import com.example.ipet.Usuario
import com.example.ipet.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val dadosUsuario = intent.extras

        var idUsuario = dadosUsuario?.getInt("idUsuario")
        var nomeUsuario = dadosUsuario?.getString("nomeUsuario")
        var emailUsuario = dadosUsuario?.getString("emailUsuario")
        var senhaUsuario = dadosUsuario?.getString("senhaUsuario")
        println("AQUI O NOME DO USUARIO QUE PASSOU"+nomeUsuario)
        val usuario = findViewById<TextView>(R.id.nomeUsuario)
        usuario.text = nomeUsuario.toString().toUpperCase()




        fun voltarTelaLogin(v: View) {
            val telaLogin2 = Intent(this, Login::class.java)
            val dadosUsuario = intent.extras

            var idUsuario = dadosUsuario?.getInt("idUsuario")
            var nomeUsuario = dadosUsuario?.getString("nomeUsuario")
            var emailUsuario = dadosUsuario?.getString("emailUsuario")
            var senhaUsuario = dadosUsuario?.getString("senhaUsuario")

            val novoUsuario = Usuario(idUsuario.toString().toInt(), nomeUsuario.toString(), emailUsuario.toString(), senhaUsuario.toString())
            val deslogar= ApiIpet.criar().deslogar(idUsuario.toString().toInt())
            deslogar.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    println("O USUARIO QUE VAI SER DESLOGADO "+ novoUsuario.idUsuario.toString().toInt() +"\n"+ idUsuario.toString().toInt() +"\n"+ novoUsuario.nome)
                    Toast.makeText(baseContext, "Você Saiu", Toast.LENGTH_SHORT).show()
                    startActivity(telaLogin2)
                }
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(baseContext, "Erro no logOff", Toast.LENGTH_SHORT).show()
                }
            })
        }




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

    fun onBackPressed(view: View) {
        // não chame o super desse método
    }

    fun irTelaPedidos(view: View) {
        val telaPedidos = Intent(this, Pedidos::class.java)
        startActivity(telaPedidos)
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


