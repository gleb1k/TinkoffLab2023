package com.example.tinkofflab2023.ui.fragment.match.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tinkofflab2023.ui.fragment.match.overview.MatchOverviewFragment

class MatchDetailsFragment: Fragment() {

    companion object {

        const val MATCH_ID_TAG = "MATCH_ID_TAG"

        fun newInstance(message: String, tag: String = MATCH_ID_TAG) =
            MatchDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(tag, message)
                }
            }
    }
}
