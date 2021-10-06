package com.oisab.beers.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.oisab.beers.R
import com.oisab.beers.screens.main.account.UserSettingsFragment
import com.oisab.beers.screens.main.orders.BeersOrdersFragment
import com.oisab.beers.screens.main.suggestions.SuggestedBeersListFragment
import moxy.MvpAppCompatFragment

class NavigationContainerFragment : Fragment(R.layout.navigation_container_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val suggestedBeersFragment = SuggestedBeersListFragment()
        val beersOrdersFragment = BeersOrdersFragment()
        val userSettingsFragment = UserSettingsFragment()
        val bottomNavigation: BottomNavigationView = view.findViewById(R.id.bottomNavigationView)

        makeCurrentFragment(suggestedBeersFragment)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.suggestions -> makeCurrentFragment(suggestedBeersFragment)
                R.id.orders -> makeCurrentFragment(beersOrdersFragment)
                R.id.userSettings -> makeCurrentFragment(userSettingsFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: MvpAppCompatFragment) {
        activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.navigationContainerFragment, fragment)
                ?.commit()
    }
}