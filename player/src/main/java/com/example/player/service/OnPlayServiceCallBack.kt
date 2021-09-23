package com.example.player.service

import com.example.player.model.ASong

interface OnPlayServiceCallBack {

    fun updateSongData(song: ASong)

    fun updateSongProgress(duration: Long, position: Long)

    fun setBufferingData(isBuffering: Boolean)

    fun setVisibilityData(isVisibility: Boolean)

    fun setPlayStatus(isPlay: Boolean)

    fun stopService()
}