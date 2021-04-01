package com.oisab.beers

import android.content.SharedPreferences
import androidx.appcompat.widget.AppCompatEditText
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class UserSettingsPresenter : MvpPresenter<UserSettingsView>() {

    fun saveUserData(sharedPref: SharedPreferences, lastName: String, lastNameValue: AppCompatEditText,
                     firstName: String, firstNameValue: AppCompatEditText) {
        saveStringData(sharedPref, lastName, lastNameValue.text.toString())
        saveStringData(sharedPref, firstName, firstNameValue.text.toString())
    }

    fun setEditTextValue(sharedPref: SharedPreferences, lastNameKey: String, lastNameValue: AppCompatEditText,
                         firstNameKey: String, firstNameValue: AppCompatEditText) {
        lastNameValue.setText(sharedPref.getString(lastNameKey, ""))
        firstNameValue.setText(sharedPref.getString(firstNameKey, ""))
    }

    private fun saveStringData(sharedPref: SharedPreferences, key: String, value: String) {
        sharedPref.edit()
                .putString(key, value)
                .apply()
    }
}