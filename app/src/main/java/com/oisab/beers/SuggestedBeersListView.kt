package com.oisab.beers

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = SingleStateStrategy::class)
interface SuggestedBeersListView : MvpView {
    fun setBeersItems(items: ArrayList<CellModel>)
}