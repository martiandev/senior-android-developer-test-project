package com.zapmap.pokemon.presentation

import android.app.Application
import android.content.Intent
import com.zapmap.pokemon.presentation.view.detail.PokemonDetailActivity
import dagger.hilt.android.HiltAndroidApp

/**
 * Added Application for Hilt
 */
@HiltAndroidApp
class PokemonApplication: Application() {
    /**
     * Solution to isolate Activities
     */
    fun launchDetails(
        id:Int
    ){
        Intent(baseContext, PokemonDetailActivity::class.java).apply {
            putExtra(PokemonDetailActivity.ID, id)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this@apply)
        }
    }

}