package com.zapmap.pokemon.utils.di

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.zapmap.pokemon.BuildConfig
import com.zapmap.pokemon.data.datasource.remote.PokemonApi
import com.zapmap.pokemon.presentation.PokemonApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(@ApplicationContext app: Context): PokemonApplication {
        return app as PokemonApplication
    }


    @Provides
    @Singleton
    fun provideContext(application: PokemonApplication): Context {

        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providesMoshi():Moshi{

        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun providesHttpLoginInterceptor():HttpLoggingInterceptor{

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(loggingInterceptor:HttpLoggingInterceptor):OkHttpClient{

        return OkHttpClient.Builder()
            .apply {
                addInterceptor(loggingInterceptor)
            }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient,moshi: Moshi): Retrofit {

        return Retrofit.Builder().baseUrl(BuildConfig.POKEMON_API_URL).client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun providesPokemonApi(retrofit: Retrofit): PokemonApi {
        return retrofit.create(PokemonApi::class.java)
    }

}