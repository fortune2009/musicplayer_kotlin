package com.example.musicplayer.di.module

import android.app.Application
import androidx.room.Room
import com.example.musicplayer.data.repository.PlaylistRepositoryImp
import com.example.musicplayer.data.source.local.AppDatabase
import com.example.musicplayer.data.source.local.dao.SongDao
import com.example.musicplayer.domain.repository.PlaylistRepository
import org.koin.dsl.module


val DatabaseModule = module {

    single { createAppDatabase(get()) }

    single { createSongDao(get()) }
}

internal fun createAppDatabase(application: Application): AppDatabase {
    return Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        AppDatabase.DB_NAME
    )
        .allowMainThreadQueries()
        .build()
}

fun createSongDao(appDatabase: AppDatabase): SongDao {
    return appDatabase.songDao
}

fun createPlaylistRepository(appDatabase: AppDatabase): PlaylistRepository {
    return PlaylistRepositoryImp(appDatabase)
}