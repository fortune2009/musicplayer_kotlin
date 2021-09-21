package com.example.musicplayer.presentation.playlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.data.model.Song
import java.io.File
import kotlin.properties.Delegates

internal class PlaylistAdapter(val mListener: OnPlaylistAdapterListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var songs: List<Song> by Delegates.observable(emptyList()) {
         _, _, _, -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewSongItemHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.holder_song, parent, false)
        return SongViewHolder(viewSongItemHolder)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       (holder as SongViewHolder).onBind(getItem(position))
    }

    private fun getItem(position: Int): Song {
        return songs[position]
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    inner class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(song: Song) {
            itemView.music_item_text_view.text = song.title ?: ""

            song.clipArt?.let { nonNullImage ->
                itemView.music_item_avatar_image_view.load(File(nonNullImage)) {
                    crossfade(true)
                    placeholder(R.dravwable.placeholder)
                    error(R.drawable.placeholder)
                    CachePolicy.ENABLED
                }
            }

            itemView.setOnLongClickListener {
                mListener.removeSongItem(song)
                true
            }

            itemView.setOnClickListener {
                mListener.playSong(song, songs as ArrayList<Song>)
            }
        }
    }

}