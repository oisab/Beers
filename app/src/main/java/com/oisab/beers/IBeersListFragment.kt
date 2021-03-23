package com.oisab.beers

import moxy.MvpView

interface IBeersListFragment: MvpView {
    fun createBeersList()
}