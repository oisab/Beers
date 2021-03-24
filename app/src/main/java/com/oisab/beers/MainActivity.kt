package com.oisab.beers

import android.os.Bundle
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainContainerView, LoginView())
                .commitNow()
    }
}