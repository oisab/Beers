package com.oisab.beers

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class BeersListPresenter : MvpPresenter<BeersListView>() {

    fun generateData(beersAdapter: BeersAdapter) {
        beersAdapter.setData(
                ArrayList<CellModel>().apply {
                    add(CellModel("Witbier", R.drawable.witbitter))
                    add(CellModel("Berliner Weisse", R.drawable.berliner_weisse))
                    add(CellModel("Blond Ale", R.drawable.blond_ale))
                    add(CellModel("Paie Ale", R.drawable.ic_launcher_foreground))
                    add(CellModel("Golden Ale", R.drawable.ic_launcher_foreground))
                    add(CellModel("Tripel", R.drawable.ic_launcher_foreground))
                    add(CellModel("India Pale", R.drawable.ic_launcher_foreground))
                    add(CellModel("Saison Ale", R.drawable.ic_launcher_foreground))
                })
    }
}