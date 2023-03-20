package com.example.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.common.Constants
import com.example.data.local.Converters
import com.example.data.local.WordInfoDatabase
import com.example.data.remote.DictionaryApi
import com.example.data.repository.WordInfoRepositoryImpl
import com.example.data.util.GsonParser
import com.example.domain.repository.WordInfoRepository
import com.example.domain.use_case.GetWordInfoUseCase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(
        repository: com.example.domain.repository.WordInfoRepository
    ): com.example.domain.use_case.GetWordInfoUseCase {
        return com.example.domain.use_case.GetWordInfoUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: com.example.data.local.WordInfoDatabase,
        api: com.example.data.remote.DictionaryApi
    ): com.example.domain.repository.WordInfoRepository {
        return com.example.data.repository.WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(
        app: Application
    ): com.example.data.local.WordInfoDatabase {
        return Room.databaseBuilder(
            app, com.example.data.local.WordInfoDatabase::class.java, "word_db"
        ).addTypeConverter(com.example.data.local.Converters(com.example.data.util.GsonParser(Gson())))
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): com.example.data.remote.DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(com.example.common.Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(com.example.data.remote.DictionaryApi::class.java)
    }
}