package com.oisab.beers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class LoginFragment : MvpAppCompatFragment(), LoginView {

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton: AppCompatButton = view.findViewById(R.id.loginButton)
        val loginText: AppCompatEditText = view.findViewById(R.id.loginTextField)
        val passwordText: AppCompatEditText = view.findViewById(R.id.passwordTextField)

        loginButton.setOnClickListener {
            loginPresenter.clickLoginButton(login = loginText.text.toString(), password = passwordText.text.toString())
        }
    }

    override fun signInAccount() {
        activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.mainContainerView, NavigationContainerFragment())
                ?.commitNow()
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}