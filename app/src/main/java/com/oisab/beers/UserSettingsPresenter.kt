package com.oisab.beers

import android.content.SharedPreferences
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class UserSettingsPresenter : MvpPresenter<UserSettingsView>() {

    fun saveUserData(sharedPref: SharedPreferences, lastNameValue: String, firstNameValue: String, userPhoneNumber: String, userEmailValue: String) {
        saveStringData(sharedPref, UserSettingsFragment.LAST_NAME, lastNameValue)
        saveStringData(sharedPref, UserSettingsFragment.FIRST_NAME, firstNameValue)
        saveStringData(sharedPref, UserSettingsFragment.PHONE_NUMBER, userPhoneNumber)
        saveStringData(sharedPref, UserSettingsFragment.EMAIL, userEmailValue)
    }

    private fun saveStringData(sharedPref: SharedPreferences, key: String, value: String) {
        sharedPref.edit()
                .putString(key, value)
                .apply()
    }
}