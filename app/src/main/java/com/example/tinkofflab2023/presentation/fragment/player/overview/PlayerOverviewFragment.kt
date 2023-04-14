package com.example.tinkofflab2023.presentation.fragment.player.overview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentPlayerOverviewBinding
import com.example.tinkofflab2023.utils.Converter

class PlayerOverviewFragment(
    private val accountId: String
) : Fragment(R.layout.fragment_player_overview) {

    private var binding: FragmentPlayerOverviewBinding? = null
    private var glide: RequestManager? = null

    private val viewModel: PlayerOverviewViewModel by viewModels {
        PlayerOverviewViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadData(accountId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlayerOverviewBinding.bind(view)
        glide = Glide.with(this)

        bindHeader()
    }

    private fun bindHeader() {
        binding?.run {

            viewModel.playerData.observe(viewLifecycleOwner) {
                if (it == null) return@observe
                with(playerHeader) {
                    tvNickname.text = it.profile.personaname
                    tvAccountId.text = it.profile.accountId.toString()
                    tvRating.text = it.rankTier.toString()

                    glide?.load(it.profile.avatarfull)?.into(ivAvatar)
                }
            }
            viewModel.playerWL.observe(viewLifecycleOwner) {
                if (it == null) return@observe
                with(playerHeader) {
                    tvWl.text = "${it.win}-${it.lose}"

                    tvWinrate.text = Converter.winrate(it.win, it.lose)
                }
            }

        }
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
