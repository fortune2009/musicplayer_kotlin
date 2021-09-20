package com.example.musicplayer.domain.usecase

import com.example.musicplayer.data.model.Song
import com.example.musicplayer.domain.repository.PlaylistRepository

class GetSongsUseCase(private val playlistRepository: PlaylistRepository) {
    fun getSongs(): List<Song>? {
        return playlistRepository.getSongs()
    }
}