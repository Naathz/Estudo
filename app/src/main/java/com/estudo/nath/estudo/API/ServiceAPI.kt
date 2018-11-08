package com.estudo.nath.estudo.API

import com.estudo.nath.estudo.model.Pessoa
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceAPI{
    @GET("/api/people/{codigousuario}/")
    fun buscarPessoa(@Path("codigousuario")codigousuario:String):Call<Pessoa>
}