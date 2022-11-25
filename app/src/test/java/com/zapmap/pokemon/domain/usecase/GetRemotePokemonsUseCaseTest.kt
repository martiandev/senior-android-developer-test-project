package com.zapmap.pokemon.domain.usecase

import com.zapmap.pokemon.domain.repository.FakeGetPokemonsRepository
import org.junit.Before

internal class GetRemotePokemonsUseCaseTest{
    lateinit var useCase:GetRemotePokemonsUseCase

    @Before
    fun setUp(){
        useCase = GetRemotePokemonsUseCase(FakeGetPokemonsRepository())
    }
}