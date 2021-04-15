package com.oisab.beers

import android.content.SharedPreferences
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class UserSettingsPresenter : MvpPresenter<UserSettingsView>() {

    fun saveUserData(sharedPref: SharedPreferences, lastName: String, lastNameValue: String,
                     firstName: String, firstNameValue: String) {
        saveStringData(sharedPref, lastName, lastNameValue)
        saveStringData(sharedPref, firstName, firstNameValue)
    }

    private fun saveStringData(sharedPref: SharedPreferences, key: String, value: String) {
        sharedPref.edit()
                .putString(key, value)
                .apply()
    }
}