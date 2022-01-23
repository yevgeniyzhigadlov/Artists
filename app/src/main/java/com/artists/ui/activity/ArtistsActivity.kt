package com.artists.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.artists.core.ui.ViewState
import com.artists.core.ui.base.BaseActivity
import com.artists.core.utils.observeNotNull
import com.artists.core.utils.toast
import com.artists.databinding.ActivityMainBinding
import com.artists.ui.adapter.ArtistsAdapter
import com.artists.ui.viewmodel.ArtistsViewModel

class ArtistsActivity : BaseActivity() {

    private val artistsViewModel: ArtistsViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.list.setEmptyView(binding.emptyLayout.emptyView)
        binding.list.setProgressView(binding.progressLayout.progressView)

        val adapter = ArtistsAdapter()
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(this)

        artistsViewModel.getAllArtists().observeNotNull(this) { state ->
            when (state) {
                is ViewState.Success -> adapter.submitList(state.data)
                is ViewState.Loading -> binding.list.showLoading()
                is ViewState.Error -> toast(state.message)
            }
        }
    }
}
