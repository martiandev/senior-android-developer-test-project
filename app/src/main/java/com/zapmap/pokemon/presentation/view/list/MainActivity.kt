package com.zapmap.pokemon.presentation.view.list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.zapmap.pokemon.databinding.ActivityMainBinding
import com.zapmap.pokemon.domain.model.PokemonItem
import com.zapmap.pokemon.presentation.PokemonApplication
import com.zapmap.pokemon.presentation.viewmodel.PokemonAnalyticsViewModel
import com.zapmap.pokemon.presentation.viewmodel.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val pokemonAdapter = PokemonAdapter { pokemonItem -> onPokemonClicked(pokemonItem) }

    private val viewModel:PokemonListViewModel  by viewModels()
    private val analyticsViewModel:PokemonAnalyticsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.result.observe(this, Observer { response ->
            when(response){
                null -> {}
                else -> pokemonAdapter.updateItems(
                    response.pokemonItems
                )
            }
        })

        binding.recyclerViewPokemon.adapter = pokemonAdapter
        binding.recyclerViewPokemon.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(1)) {
                    lifecycleScope.launch {
                        viewModel.getPokemons()
                    }
                }
            }
        })
        lifecycleScope.launchWhenCreated {
            viewModel.getPokemons()
        }
    }


    private fun onPokemonClicked(pokemonItem: PokemonItem) {
        analyticsViewModel.onPokemonSelected(
            pokemonItem.getId()
        )
        (application as PokemonApplication)
            .launchDetails(pokemonItem.getId())

    }
}