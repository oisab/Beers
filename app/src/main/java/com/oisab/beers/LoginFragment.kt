package com.oisab.beers

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment: Fragment(R.layout.login_fragment), ILoginFragment {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickLoginButton()
    }

    override fun validateLogin(): Boolean {
        val textLogin: TextView? = view?.findViewById(R.id.loginTextField)
            return textLogin!!.text.toString().contains('@') && textLogin.text.toString().contains('.')
    }

    override fun validatePassword(): Boolean {
        val textPassword: TextView? = view?.findViewById(R.id.passwordTextField)
            return textPassword!!.text.toString().length > 6
    }

    override fun getError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    private fun clickLoginButton() {
        val loginButton: Button? = view?.findViewById(R.id.loginButton)
        loginButton?.setOnClickListener{
            if(!validateLogin()) {
                getError("Login validation Failed")
                return@setOnClickListener }
            if(!validatePassword()) {
                getError("Password validation Failed")
                return@setOnClickListener }
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.mainContainerView, BeersListFragment())
                    ?.commitNow()
        }
    }
}