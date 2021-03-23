package com.oisab.beers

import moxy.MvpView

interface ILoginFragment: MvpView {
    fun validateLogin(): Boolean
    fun validatePassword(): Boolean
    fun getError(message: String)
}