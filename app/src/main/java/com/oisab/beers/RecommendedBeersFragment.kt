package com.oisab.beers

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class RecommendedBeersFragment : Fragment(R.layout.recommended_beers_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val accountButton: Button = view.findViewById(R.id.accountButton)
        val beersListButton: Button = view.findViewById(R.id.beersListButton)

        accountButton.setOnClickListener {
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.mainContainerView, UserSettingsFragment())
                    ?.commitNow()
        }

        beersListButton.setOnClickListener {
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.mainContainerView, BeersListFragment())
                    ?.commitNow()
        }
    }
}