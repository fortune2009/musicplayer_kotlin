package com.example.player

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.player.model.ASong

class SongPlayerViewModel : ViewModel() {

    private val _playerData = MutableLiveData<ASong>()
    val playerData: LiveData<ASong> = _playerData
    private val _isVisibleData = MutableLiveData<Boolean>()
    val isVisibleData: LiveData<Boolean> = _isVisibleData
    private val _isBufferingData = MutableLiveData<Boolean>()
    val isBufferingData: LiveData<Boolean> = _isBufferingData
    private val _isPlayData = MutableLiveData<Boolean>()
    val isPlayData: LiveData<Boolean> = _isPlayData
    private val _playingPercentData = MutableLiveData<Int>()
    val playPercentData: LiveData<Int> = _playingPercentData
    private val _songDurationTextData = MutableLiveData<String>()
    val songDurationTextData: LiveData<String> = _songDurationTextData
    private val _songPositionTextData = MutableLiveData<String>()
    val songPositionTextData: LiveData<String> = _songPositionTextData
    private val _songDurationData = MutableLiveData<Int>()
    val songDuration
}
