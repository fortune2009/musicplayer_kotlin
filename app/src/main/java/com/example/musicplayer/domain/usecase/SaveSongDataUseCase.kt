package com.example.musicplayer.domain.usecase

import com.example.musicplayer.data.model.Song
import com.example.musicplayer.domain.repository.PlaylistRepository

class SaveSongDataUseCase(private val playlistRepository: PlaylistRepository) {

    fun saveSongItem(song: Song) {
        playlistRepository.saveSongData(song)
    }
}