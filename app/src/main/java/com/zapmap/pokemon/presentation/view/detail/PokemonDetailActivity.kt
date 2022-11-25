package com.zapmap.pokemon.presentation.view.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import coil.load
import com.zapmap.pokemon.databinding.ActivityPokemonDetailBinding
import com.zapmap.pokemon.domain.model.Pokemon
import com.zapmap.pokemon.presentation.viewmodel.PokemonDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonDetailBinding


    private lateinit var remotePokemonItem: Pokemon
    private val typesAdapter = TypesAdapter()
    private val viewModel: PokemonDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { onBackPressed() }
        viewModel.result.observe(this, Observer { pokemon ->
            when(pokemon){
                null ->{}
                else -> displayPokemon(pokemon)
            }
        })
        lifecycleScope.launchWhenCreated {
            var id = intent.getIntExtra(ID,0)
            if(id>0){
                viewModel
                    .getPokemon(id)
            }
        }
        binding.recyclerViewTypes.adapter = typesAdapter

    }

    private fun displayPokemon(pokemon: Pokemon) {
        binding.apply {
            textViewPokemonName.text = pokemon.name.capitalize()
            textViewWeight.text = pokemon.weight.toString()
            textViewHeight.text = pokemon.height.toString()
            imageViewPokemonFront.load(pokemon.sprites.frontDefault)
            typesAdapter.updateItems(pokemon.types.map { it.type.name })
        }
    }

    companion object{
        val ID = "id"
    }
}