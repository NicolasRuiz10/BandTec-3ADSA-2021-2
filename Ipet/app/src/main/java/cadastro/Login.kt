package cadastro

import API.ApiIpet
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.ipet.PetShop
import com.example.ipet.R
import home.Home
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    lateinit var etemail:EditText
    lateinit var etsenha:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etemail = findViewById(R.id.et_email)
        etsenha = findViewById(R.id.et_senha)
    }
    fun irTelaCadastro(v: View) {
        val telaCadastro = Intent(this, Cadastro::class.java)
        startActivity(telaCadastro)
    }
    fun logar(v:View) {
        val novoUsuario = UsuarioLogin(etemail.text.toString(), etsenha.text.toString())

        val postAutenticar = ApiIpet.criar().autenticar(novoUsuario)

        val telaHome = Intent(this, Home::class.java)

        postAutenticar.enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                println("AQUI")
                t.printStackTrace()
                Toast.makeText(baseContext, "Erro na API", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    println( "AQUI********************" + response.body())
                    Toast.makeText(baseContext, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                    startActivity(telaHome)
                } else {
                    Toast.makeText(baseContext, "Erro: ${response.errorBody()}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}