package com.oisab.beers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oisab.beers.screens.start.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainContainerView, LoginFragment())
                .commitNow()
    }
}