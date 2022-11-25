package com.zapmap.pokemon.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zapmap.pokemon.BuildConfig
import com.zapmap.pokemon.domain.model.PokemonResponse
import com.zapmap.pokemon.domain.usecase.GetRemotePokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val useCase: GetRemotePokemonsUseCase
):ViewModel() {

    private val _result:MutableLiveData<PokemonResponse?> = MutableLiveData();
    var result:LiveData<PokemonResponse?> = _result
    var offset = 0
    var next:String? = ""

    fun getPokemons(){
        when(next){
            null->{}
            else -> next()
        }
    }
    fun next(){
        viewModelScope.launch {
            var response = useCase.invoke(
                BuildConfig.DEFAULT_LIMIT,
                offset
            )
            if(response!=null) {
                offset = response.offset
                next = response.next
            }

            _result.postValue(response)
        }
    }




}