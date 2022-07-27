package com.shubham.tmdbclient.presentation.di.core

import com.shubham.tmdbclient.domain.repository.ArtistsRepository
import com.shubham.tmdbclient.domain.repository.MovieRepository
import com.shubham.tmdbclient.domain.repository.TvShowRepository
import com.shubham.tmdbclient.domain.use_cases.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetArtistUseCase(artistsRepository: ArtistsRepository): GetArtistsUseCase {

        return GetArtistsUseCase(artistsRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(artistsRepository: ArtistsRepository): UpdateArtistsUseCase {

        return UpdateArtistsUseCase(artistsRepository)
    }


    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {

        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {

        return UpdateMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {

        return GetTvShowsUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase {

        return UpdateTvShowUseCase(tvShowRepository)
    }



}