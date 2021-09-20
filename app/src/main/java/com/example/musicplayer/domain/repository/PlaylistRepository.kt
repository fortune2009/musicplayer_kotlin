package com.example.musicplayer.domain.repository

import com.example.musicplayer.data.model.Song

interface PlaylistRepository {

    fun saveSongData(song: Song): Long

    fun getSongs(): List<Song>

    fun delete(song: Song)
}