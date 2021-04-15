package com.oisab.beers

import android.content.SharedPreferences
import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = SingleStateStrategy::class)
interface UserSettingsView : MvpView {
}