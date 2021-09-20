package com.example.musicplayer.data.repository

import com.example.musicplayer.data.model.Song
import com.example.musicplayer.data.source.local.AppDatabase
import com.example.musicplayer.domain.repository.PlaylistRepository

class PlaylistRepositoryImp(private val appDatabase: AppDatabase) : PlaylistRepository {

    override fun saveSongData(song: Song): Long {
        return appDatabase.songDao.insert(song)
    }

    override fun getSongs(): List<Song> {
        return appDatabase.songDao.loadAll()
    }

    override fun delete(song: Song) {
        return appDatabase.songDao.delete(song)
    }


}