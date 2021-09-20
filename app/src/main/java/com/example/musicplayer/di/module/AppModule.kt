package com.example.musicplayer.di.module

import com.example.musicplayer.domain.repository.PlaylistRepository
import com.example.musicplayer.domain.usecase.DeleteSongUseCase
import com.example.musicplayer.domain.usecase.GetSongsUseCase
import com.example.musicplayer.domain.usecase.SaveSongDataUseCase

val AppModule = module {

    viewModel { PlaylistViewModel(get(), get(), get())}

    single { createGetSongsUseCase(get()) }

    single { createDeleteSongsUseCase(get()) }

    single { createSaveSongDataUseCase(get()) }

    single { createPlaylistRepository(get()) }
}


fun createSaveSongDataUseCase(playlistRepository: PlaylistRepository
): SaveSongDataUseCase {
    return SaveSongDataUseCase(playlistRepository)
}

fun createDeleteSongsUseCase(playlistRepository: PlaylistRepository
): DeleteSongUseCase {
    return DeleteSongUseCase(playlistRepository)
}

fun createGetSongsUseCase(playlistRepository: PlaylistRepository): GetSongsUseCase {
    return GetSongsUseCase(playlistRepository)
}