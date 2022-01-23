package com.artists.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.artists.core.ui.ViewState
import com.artists.repository.ArtistsRepository
import com.artists.storage.entity.ArtistDb

class ArtistsViewModel @ViewModelInject constructor(
        artistsRepository: ArtistsRepository
) : ViewModel() {

    private val artistsDb: LiveData<ViewState<List<ArtistDb>>> = artistsRepository.getAllArtists().asLiveData()

    fun getAllArtists(): LiveData<ViewState<List<ArtistDb>>> = artistsDb
}