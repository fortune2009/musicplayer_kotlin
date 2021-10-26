package com.example.player.media

import com.example.player.model.ASong
import java.time.Duration

interface OnMediaAdapterCallback {

    fun onSongChanged(song: ASong)

    fun onPlaybackStateChanged(state: Int)

    fun setDuration(duration: Long, position: Long)

    fun addNewPlaylistToCurrent(songList: ArrayList<ASong>)

    fun onShuffle(isShuffle: Boolean)

    fun onRepeat(isRepeat: Boolean)

    fun onRepeatAll(repeatAll: Boolean)
}