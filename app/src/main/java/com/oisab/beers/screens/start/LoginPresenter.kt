package com.oisab.beers.screens.start

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {

    private fun validateLogin(login: String): Boolean {
        return login.matches(Regex("^[\\w! #\$%&‘*+-/=?^`~.]{1,64}@[\\w! #\$%&‘*+-/=?^`~.]" +
                "{1,253}\\.[a-z]{2,6}\$")) && login.length <= 256
    }

    private fun validatePassword(password: String): Boolean {
        return password.matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])" +
                "(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,32}\$"))
    }

    fun clickLoginButton(login: String, password: String) {
        if (!validateLogin(login = login)) {
            viewState.showError("Login validation failed")
        }
        else if (!validatePassword(password = password)) {
            viewState.showError("Password validation failed")
        }
        else {
            viewState.signInAccount()
        }
    }
}