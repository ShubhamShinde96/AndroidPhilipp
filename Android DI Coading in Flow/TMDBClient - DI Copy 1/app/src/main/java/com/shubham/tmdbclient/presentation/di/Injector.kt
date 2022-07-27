package com.shubham.tmdbclient.presentation.di

import com.shubham.tmdbclient.data.model.movie.Movie
import com.shubham.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.shubham.tmdbclient.presentation.di.movie.MovieSubComponent
import com.shubham.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createArtistSubComponent(): ArtistSubComponent

    fun createMovieSubComponent(): MovieSubComponent

    fun createTvShowSubComponent(): TvShowSubComponent

}