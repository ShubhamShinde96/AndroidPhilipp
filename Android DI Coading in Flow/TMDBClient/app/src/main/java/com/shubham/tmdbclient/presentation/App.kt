package com.shubham.tmdbclient.presentation

import android.app.Application
import com.shubham.tmdbclient.BuildConfig
import com.shubham.tmdbclient.presentation.di.Injector
import com.shubham.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.shubham.tmdbclient.presentation.di.core.*
import com.shubham.tmdbclient.presentation.di.movie.MovieSubComponent
import com.shubham.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
//            .netModule(NetModule("https://api.themoviedb.org/3/"))
//            .remoteDataModule(RemoteDataModule("ae34a614d216948277efbebf4d21caaa"))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}