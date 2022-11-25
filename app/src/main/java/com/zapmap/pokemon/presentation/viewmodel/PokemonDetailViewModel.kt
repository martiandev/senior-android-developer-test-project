package com.zapmap.pokemon.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zapmap.pokemon.domain.model.Pokemon
import com.zapmap.pokemon.domain.usecase.GetRemotePokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val useCase: GetRemotePokemonUseCase
):ViewModel() {

    private val _result:MutableLiveData<Pokemon?> = MutableLiveData();
    var result:LiveData<Pokemon?> = _result

    fun getPokemon(
        id:Int,
    ){
        viewModelScope.launch {
            var response = useCase.invoke(
                id
            )
            _result.postValue(response)
        }
    }

}