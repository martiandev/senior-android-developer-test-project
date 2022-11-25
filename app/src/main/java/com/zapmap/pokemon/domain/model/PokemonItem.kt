package com.zapmap.pokemon.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonItem (
    val name:String,
    val url:String
){
    fun getId():Int{
        val stringId = url.removeSuffix("/").substringAfterLast("/")
        return stringId.toInt()
    }
}