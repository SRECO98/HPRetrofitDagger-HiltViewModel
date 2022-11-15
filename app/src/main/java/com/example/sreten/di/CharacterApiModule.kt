package com.example.sreten.di

import android.app.Application
import androidx.room.Room
import com.example.sreten.data.api.ApiConstants
import com.example.sreten.data.api.CharacterApi
import com.example.sreten.data.room.CharacterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CharacterApiModule {

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder) : CharacterApi{
        return builder
            .build()
            .create(CharacterApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): CharacterDatabase =
        Room.databaseBuilder(app, CharacterDatabase::class.java, ApiConstants.NAME_OF_DB)
            .build()
}