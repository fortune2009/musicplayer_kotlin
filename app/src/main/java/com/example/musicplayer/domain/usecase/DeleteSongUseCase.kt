package com.example.musicplayer.domain.usecase

import com.example.musicplayer.data.model.Song
import com.example.musicplayer.domain.repository.PlaylistRepository

class DeleteSongUseCase(private val playlistRepository: PlaylistRepository) {
    fun deleteSongItem(song: Song) {
        playlistRepository.delete(song)
    }
}