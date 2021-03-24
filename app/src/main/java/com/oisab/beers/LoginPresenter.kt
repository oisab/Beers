package com.oisab.beers

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class LoginPresenter : MvpPresenter<ILoginView>() {

    private fun validateLogin(login: String): Boolean {
        return login.contains('@') && login.contains('.')
    }

    private fun validatePassword(password: String): Boolean {
        return password.length > 6
    }

    fun clickLoginButton(login: String, password: String): Boolean {
        return if (!validateLogin(login = login)) {
            viewState.getError("Login validation Failed")
            false
        }
        else if (!validatePassword(password = password)) {
            viewState.getError("Password validation Failed")
            false
        }
        else
            true
    }
}