package com.shubham.tmdbclient.presentation.di.core

import com.shubham.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.shubham.tmdbclient.presentation.di.movie.MovieSubComponent
import com.shubham.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
])
interface AppComponent {

    fun artistSubComponent(): ArtistSubComponent.Factory

    fun movieSubComponent(): MovieSubComponent.Factory

    fun tvShowSubComponent(): TvShowSubComponent.Factory

}