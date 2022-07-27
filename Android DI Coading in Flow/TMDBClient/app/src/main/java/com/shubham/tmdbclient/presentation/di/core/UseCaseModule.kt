package com.shubham.tmdbclient.presentation.di.core


import com.shubham.tmdbclient.domain.repository.ArtistsRepository
import com.shubham.tmdbclient.domain.repository.MovieRepository
import com.shubham.tmdbclient.domain.repository.TvShowRepository
import com.shubham.tmdbclient.domain.use_cases.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase {
        return UpdateTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistsRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistsRepository):UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistRepository)
    }

}