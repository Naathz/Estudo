package com.estudo.nath.estudo.model

import com.google.gson.annotations.SerializedName

data class Pessoa(
        @SerializedName("name") val nome: String,
        @SerializedName("hair_color") val cabelo: String,
        @SerializedName("skin_color") val pele: String,
        @SerializedName("birth_year") val nascimento: String,
        @SerializedName("gender") val genero: String
        )