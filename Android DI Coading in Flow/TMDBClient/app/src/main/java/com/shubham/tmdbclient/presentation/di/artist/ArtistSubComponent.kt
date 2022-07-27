package com.shubham.tmdbclient.presentation.di.artist

import com.shubham.tmdbclient.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistCope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {

        fun create(): ArtistSubComponent
    }

}