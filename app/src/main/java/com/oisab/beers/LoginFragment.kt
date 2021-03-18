package com.oisab.beers

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlin.math.log

class LoginFragment: Fragment(R.layout.login_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loginButton: Button = view.findViewById(R.id.loginButton)
        loginButton.setOnClickListener{
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.mainContainerView, BeersListFragment.newInstance())
                    ?.commitNow()
        }
    }

    companion object{
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }
}