package com.example.musicplayer.data.source.local

import androidx.room.RoomDatabase
import com.example.musicplayer.data.source.local.dao.SongDao

abstract class AppDatabase : RoomDatabase() {

    abstract val songDao: SongDao

    companion object {
        const val DB_NAME = "MusicPlayerApp.db"
    }
}