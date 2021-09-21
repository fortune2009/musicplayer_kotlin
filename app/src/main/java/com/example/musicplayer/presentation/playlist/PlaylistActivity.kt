package com.example.musicplayer.presentation.playlist

import com.example.player.PlayerActivity

class PlaylistActivity : PlayerActivity(), OnPlaylistAdapterListener {

    private var adapter: PlaylistAdapter? = null
    private var viewModel: PlaylistViewModel by viewModel()



}