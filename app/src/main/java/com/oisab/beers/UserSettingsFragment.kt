package com.oisab.beers

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class UserSettingsFragment: MvpAppCompatFragment(), UserSettingsView {
    @InjectPresenter
    lateinit var userSettingsPresenter: UserSettingsPresenter

    private var LAST_NAME = "last_name"
    private var FIRST_NAME = "first_name"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.user_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userSharedPref = activity!!.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE)
        val lastNameEditText: AppCompatEditText = view.findViewById(R.id.userLastName)
        val firstNameEditText: AppCompatEditText = view.findViewById(R.id.userFirstName)
        val saveUserDataButton: AppCompatButton = view.findViewById(R.id.saveUserDataButton)

        saveUserDataButton.setOnClickListener {
            userSettingsPresenter.saveUserData(userSharedPref, LAST_NAME, lastNameEditText, FIRST_NAME, firstNameEditText)
            showToast("Saved")
        }
        userSettingsPresenter.setEditTextValue(userSharedPref, LAST_NAME, lastNameEditText, FIRST_NAME, firstNameEditText)
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}