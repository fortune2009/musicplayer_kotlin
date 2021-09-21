package com.example.musicplayer.presentation.playlist

import com.example.musicplayer.data.model.Song

interface OnPlaylistAdapterListener {
    fun playSong(song: Song, songs: ArrayList<Song>)

    fun removeSongItem(song: Song)
}