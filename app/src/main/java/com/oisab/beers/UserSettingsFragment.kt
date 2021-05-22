package com.oisab.beers

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class UserSettingsFragment : MvpAppCompatFragment(), UserSettingsView {
    @InjectPresenter
    lateinit var userSettingsPresenter: UserSettingsPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.user_settings_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userSharedPref = activity!!.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE)
        val lastNameEditText: AppCompatEditText = view.findViewById(R.id.userLastName)
        val firstNameEditText: AppCompatEditText = view.findViewById(R.id.userFirstName)
        val userPhoneNumber: AppCompatEditText = view.findViewById(R.id.userPhoneNumber)
        val userEmailEditText: AppCompatEditText = view.findViewById(R.id.userEmail)
        val saveUserDataButton: AppCompatButton = view.findViewById(R.id.saveUserDataButton)

        saveUserDataButton.setOnClickListener {
            userSettingsPresenter.saveUserData(userSharedPref, lastNameEditText.text.toString(),
                    firstNameEditText.text.toString(), userPhoneNumber.text.toString(),
                    userEmailEditText.text.toString())
        }
        lastNameEditText.setText(userSharedPref.getString(LAST_NAME, ""))
        firstNameEditText.setText(userSharedPref.getString(FIRST_NAME, ""))
        userPhoneNumber.setText(userSharedPref.getString(PHONE_NUMBER, ""))
        userEmailEditText.setText(userSharedPref.getString(EMAIL, ""))
    }

    companion object {
        const val LAST_NAME = "last_name"
        const val FIRST_NAME = "first_name"
        const val EMAIL = "email"
        const val PHONE_NUMBER = "phone_number"
    }
}