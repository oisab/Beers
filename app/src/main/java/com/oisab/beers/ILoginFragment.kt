package com.oisab.beers

interface ILoginFragment {
    fun validateLogin(): Boolean
    fun validatePassword(): Boolean
    fun getError(message: String)
}