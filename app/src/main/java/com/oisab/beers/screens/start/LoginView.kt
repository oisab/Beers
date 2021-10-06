package com.oisab.beers.screens.start

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = SingleStateStrategy::class)
interface LoginView : MvpView {
    fun showError(message: String)
    fun signInAccount()
}