package com.zapmap.pokemon.domain.model

data class PokemonResponse(
    val offset:Int,
    val limit:Int,
    val pokemonItems:List<PokemonItem>,
    val next:String?
)
