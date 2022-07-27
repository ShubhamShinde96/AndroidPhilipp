package com.shubham.tmdbclient.presentation.di.tvshow

import com.shubham.tmdbclient.domain.use_cases.GetTvShowsUseCase
import com.shubham.tmdbclient.domain.use_cases.UpdateTvShowUseCase
import com.shubham.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {

        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowUseCase)
    }

}