package com.zapmap.pokemon.data.entity.remote

import android.graphics.Bitmap.Config
import android.util.Log
import com.squareup.moshi.Json
import com.zapmap.pokemon.BuildConfig
import com.zapmap.pokemon.domain.model.PokemonItem
import com.zapmap.pokemon.domain.model.PokemonResponse

data class PokemonResponseEntity(
    val next: String? = null, // if this is null we've reached the end of the list
    @Json(name = "results")
    val pokemonItems: List<PokemonItemEntity>
){
    /**
     * Converts PokemonResponseEntity to PokemonResponse
     * @return PokemonResponse - Object recognized by domain layer
     * @return null - failed to fetch data
     */
    fun toPokemonResponse(): PokemonResponse? {
        var offset = 0
        var limit = BuildConfig.DEFAULT_LIMIT
        if(this.next!=null){
            var query = next.subSequence(IntRange(34,next.lastIndex)).toString()
            var parameters = query.split("&")
            offset = parameters[0].replace("offset=","")?.toInt()!!
            limit = parameters[1].replace("limit=","").toInt()!!
        }

        var list:ArrayList<PokemonItem> = ArrayList();
        pokemonItems.forEach(){ item ->
            list.add(item.toPokemonItem())
        }
        return PokemonResponse(
            offset,
            limit,
            list,
            this.next
        )

    }
}

