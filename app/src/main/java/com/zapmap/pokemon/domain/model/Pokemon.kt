package com.zapmap.pokemon.domain.model

data class Pokemon (
    val name:String,
    val weight:Int,
    val height:Int,
    val types: List<TypeItem>,
    val sprites: Sprite
)
