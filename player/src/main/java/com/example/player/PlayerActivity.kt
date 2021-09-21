package com.example.player

import android.content.ComponentName
import android.content.Context
import android.content.ServiceConnection
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import com.example.player.model.ASong

open class PlayerActivity : AppCompatActivity()
{

    private var mService: SongPlayerService? = null
    private var mBound = false
    private var mSong: ASong? = null
    private var mSongList: MutableList<ASong>? = null
    private var msg = 0
    val songPlayerViewModel: SongPlayerViewModel = getPlayerViewModelInstance()

    private val mHandler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {

            super.handleMessage(msg)

            when (msg.what) {
                ACTION_PLAY_SONG_IN_LIST -> mService?.play(mSongList, mSong)
                ACTION_PAUSE -> mService?.pause()
                ACTION_STOP -> {
                    mService?.stop()
                    songPlayerViewModel.stop()
                }
            }
        }
    }

        private val mConnection = object : ServiceConnection {

            override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
                val binder = service as SongPlayerService.LocalBinder
                mService = binder.service
                mBound = true
                mService?.subscribeToSongPlayerUpdates()
                mHandler.sendEmptyMessage(msg)
                mService?.addListener(this@BaseSongPlayerActivity)
            }

            override fun onServiceDisconnected(p0: ComponentName?) {
                mBound = false
                mService?.removeListener()
                mService = null
            }
        }

        private fun bindPlayerService() {
            if(!mBound) bindService(Intent(this, SongPlayerService::class.java),
                mConnection, Context.BIND_AUTO_CREATE)
        }

        fun play(songList: MutableList<ASong>?, song: Asong) {
            msg = ACTION_PLAY_SONG_IN_LIST
            mSong = song
            mSongList = songList
            songPlayerViewModel.setPlayStatus(true)
            if(mService == null) bindPlayerService()
            else mHandler.sendEmptyMessage(msg)
        }
    private fun pause() {
        msg = ACTION_PAUSE
        songPlayerViewModel.setPlayStatus(false)
        if(mService == null) bindPlayerService()
        else mHandler.sendEmptyMessage(msg)
    }

    fun stop() {
        msg = ACTION_STOP
        songPlayerViewModel.setPlayStatus(false)
        if(mService == null) bindPlayerService()
        else mHandler.sendEmptyMessage(msg)
    }

    fun next() {
        mService?.skipToNext()
    }

    fun previous() {
        mService?.skipToPrevious()
    }

    fun toggle() {
        if(songPlayerViewModel.isPlayData.value == true) pause()
        else songPlayerViewModel.playerData.value?.let { it1 -> play(mSongList, it1)}
    }

    fun seekTo(position: Long?) {
        position?.let { nonNullPosition ->
            songPlayerViewModel.seekTo(nonNullPosition)
            mService?.seekTo(nonNullPosition)
        }
    }

    fun addNewPlaylistToCurrent(songList: ArrayList<ASong>?) {
        mService?.addNewPlaylistToCurrent(songList)
    }

    fun shuffle() {
        mService?.onShuffle
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
    }
}