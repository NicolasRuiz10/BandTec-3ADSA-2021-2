package API

import Model.ItensPedidos
import Model.PedidosModel
import Model.PetShopModel
import Model.ProdutosModel
import com.example.ipet.Usuario
import cadastro.UsuarioLogin
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiIpet {
    @GET("usuarios")
    fun get() : Call<List<Usuario>>

    @GET("ipet")
    fun getPetshop() : Call<List<PetShopModel>>

    @GET("produtos")
    fun getProdutos(): Call<List<ProdutosModel>>

    @GET("usuarios/{id}")
    fun get(@Path("id") id:Int) : Call<Usuario>

    @POST("pedido/usuario/id/{id}")
    fun postPedidos(@Body novoPedido: PedidosModel, @Path("id") id:Int) : Call<Void>

    @POST("itens/pedido/id/{idPedido}/{idProduto}")
    fun postItensPedidos(@Body novoPedido: ItensPedidos, @Path("idPedido") idPedido:Int, @Path("idProduto") idProduto: Int?) : Call<Void>

    @GET("pedido")
    fun getPedido(): Call<List<PedidosModel>>

    @POST("usuarios")
    fun post(@Body novoIpet: Usuario) : Call<Void>

    @POST("usuarios/autenticar")
    fun autenticar(@Body novoIpet: UsuarioLogin) : Call<Void>

    @POST("usuarios/logoff/{id}")
    fun deslogar( @Path("id") idUsuario:Int) : Call<Void>

    companion object {
        var BASE_URL = "http://34.226.239.106:8080/"
        fun criar() : ApiIpet {
            var retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiIpet::class.java)
        }
    }
}