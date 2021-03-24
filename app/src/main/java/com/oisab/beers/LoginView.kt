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

class LoginView: MvpAppCompatFragment(), ILoginView {

    @InjectPresenter lateinit var loginPresenter: LoginPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton: AppCompatButton = view.findViewById(R.id.loginButton)
        val loginText: AppCompatEditText = view.findViewById(R.id.loginTextField)
        val passwordText: AppCompatEditText = view.findViewById(R.id.passwordTextField)

        loginButton.setOnClickListener {
            if(loginPresenter.clickLoginButton(login = loginText.text.toString(), password = passwordText.text.toString()))
                activity?.supportFragmentManager
                        ?.beginTransaction()
                        ?.replace(R.id.mainContainerView, BeersListView())
                        ?.commitNow()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun getError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}