package com.estudo.nath.estudo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pesquisar.*

class PesquisarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisar)

        btPesquisar.setOnClickListener(){
        val mandarParaOutraTela = Intent(this, ResultadoActivity::class.java)
            mandarParaOutraTela.putExtra("DADOS", etDigitar.text.toString())
            startActivity(mandarParaOutraTela)
        }

        btSobre.setOnClickListener(){
            val abrirTela = Intent(this,AboutActivity::class.java)
            startActivity(abrirTela)

        }

    }
}
