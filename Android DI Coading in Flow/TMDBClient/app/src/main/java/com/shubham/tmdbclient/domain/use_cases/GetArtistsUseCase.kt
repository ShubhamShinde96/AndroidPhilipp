package com.shubham.tmdbclient.domain.use_cases

import com.shubham.tmdbclient.data.model.artist.Artist
import com.shubham.tmdbclient.domain.repository.ArtistsRepository

class GetArtistsUseCase(private val artistsRepository: ArtistsRepository) {

    suspend fun execute(): List<Artist>? = artistsRepository.getArtists()

}