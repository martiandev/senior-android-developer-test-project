package com.zapmap.pokemon.data.datasource.remote

import com.zapmap.pokemon.data.entity.remote.PokemonEntity
import com.zapmap.pokemon.data.entity.remote.PokemonResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
    suspend fun fetchPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<PokemonResponseEntity>

    @GET("pokemon/{id}")
    suspend fun fetchPokemonById(
        @Path("id") id: Int,
    ): Response<PokemonEntity>
}