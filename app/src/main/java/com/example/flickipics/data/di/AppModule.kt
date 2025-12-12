package com.example.flickipics.data.di

import android.content.Context
import com.example.flickipics.data.api.MovieService
import com.example.flickipics.data.repo.MovieRepository
import com.example.flickipics.data.repo.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        api: MovieService,
        @IoDispatcher io: CoroutineDispatcher,
        @ApplicationContext context: Context
    ): MovieRepository =
        MovieRepositoryImpl(api, io, context)

}
