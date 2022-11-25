package com.zapmap.pokemon.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zapmap.pokemon.domain.usecase.PokemonSelectedAnalyticsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonAnalyticsViewModel @Inject constructor(
    private val useCase: PokemonSelectedAnalyticsUseCase
):ViewModel() {

    private val _result:MutableLiveData<Boolean> = MutableLiveData();
    var result:LiveData<Boolean> = _result

    fun onPokemonSelected(
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