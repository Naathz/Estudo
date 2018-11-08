package com.estudo.nath.estudo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.estudo.nath.estudo.API.ServiceAPI
import com.estudo.nath.estudo.model.Pessoa
import kotlinx.android.synthetic.main.activity_resultado.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val buscarOMandarDaOutraTela = intent.getStringExtra("DADOS")


        //chamar os dados do serviço
        val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        //chamar api
        val service = retrofit.create(ServiceAPI::class.java)
        service.buscarPessoa(buscarOMandarDaOutraTela)
                .enqueue(object: Callback<Pessoa>{
                    override fun onFailure(call: Call<Pessoa>?, t: Throwable?) {
                    Toast.makeText(this@ResultadoActivity,"Não deu", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<Pessoa>?, response: Response<Pessoa>?) {
                    val pessoa = response?.body()
                        tvNome.text = pessoa?.nome
                        tvCabelo.text = pessoa?.cabelo
                        tvPele.text = pessoa?.pele
                        tvNascimento.text = pessoa?.nascimento
                        tvGenero.text = pessoa?.genero
                    }

                })
    }
}
