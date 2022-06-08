package cadastro

import API.ApiIpet
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.ipet.*
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
        val telaHome = Intent(this, Home::class.java)
        val telaCadastro = Intent(this, Cadastro::class.java)
        val telaCarrinho = Intent(this, Carrinho::class.java)

        val novoUsuario = UsuarioLogin(etemail.text.toString(), etsenha.text.toString())
        val postAutenticar = ApiIpet.criar().autenticar(novoUsuario)

        postAutenticar.enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na API", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {

                    val getUsuarios = ApiIpet.criar().get()
                    getUsuarios.enqueue(object : Callback<List<Usuario>>{
                        override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>
                        ) {
                            Toast.makeText(baseContext, "Login ou senha incorretos", Toast.LENGTH_SHORT).show()
                            response.body()?.forEach { usuario ->
                                if (usuario.senha.equals(novoUsuario.senha, ignoreCase = true) &&
                                    usuario.email.equals(novoUsuario.email, ignoreCase = true)
                                ) {
                                    val usuarioLogado = Usuario(usuario.idUsuario, usuario.nome, usuario.email, usuario.senha)


                                    telaHome.putExtra("idUsuario", usuarioLogado.idUsuario)
                                    telaHome.putExtra("nomeUsuario", usuarioLogado.nome)
                                    telaHome.putExtra("emailUsuario", usuarioLogado.email)
                                    telaHome.putExtra("senhaUsuario", usuarioLogado.senha)

                                    telaCadastro.putExtra("idUsuario", usuarioLogado.idUsuario)
                                    telaCadastro.putExtra("nomeUsuario", usuarioLogado.nome)
                                    telaCadastro.putExtra("emailUsuario", usuarioLogado.email)
                                    telaCadastro.putExtra("senhaUsuario", usuarioLogado.senha)

                                    telaCarrinho.putExtra("idUsuario", usuarioLogado.idUsuario)
                                    telaCarrinho.putExtra("nomeUsuario", usuarioLogado.nome)
                                    telaCarrinho.putExtra("emailUsuario", usuarioLogado.email)
                                    telaCarrinho.putExtra("senhaUsuario", usuarioLogado.senha)

                                    Toast.makeText(baseContext, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                                    startActivity(telaHome)
                                }
                            }
                        }
                        override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
                            Toast.makeText(baseContext, "Erro", Toast.LENGTH_SHORT).show()
                        }
                    })

                } else {
                    Toast.makeText(baseContext, "Erro: ${response.errorBody()}", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }
}