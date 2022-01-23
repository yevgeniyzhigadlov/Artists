package com.artists.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.artists.R
import com.artists.core.utils.inflate
import com.artists.databinding.RowArtistBinding
import com.artists.storage.entity.ArtistDb

class ArtistsAdapter : ListAdapter<ArtistDb, ArtistsAdapter.ArtistHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArtistHolder(parent.inflate(R.layout.row_artist))

    override fun onBindViewHolder(artistHolder: ArtistHolder, position: Int) = artistHolder.bind(getItem(position))

    class ArtistHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = RowArtistBinding.bind(itemView)

        fun bind(artist: ArtistDb) = with(itemView) {
            binding.name.text = artist.name
            binding.listeners.text = context.getString(R.string.listeners, artist.listeners)
            binding.image.load(artist.image) {
                placeholder(R.drawable.placeholder)
                error(R.drawable.placeholder)
            }
            setOnClickListener {  }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ArtistDb>() {
            override fun areItemsTheSame(oldItem: ArtistDb, newItem: ArtistDb): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: ArtistDb, newItem: ArtistDb): Boolean = oldItem == newItem
        }
    }
}