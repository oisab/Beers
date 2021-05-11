package com.oisab.beers

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class SuggestedBeersListPresenter : MvpPresenter<SuggestedBeersListView>() {
    private val items = ArrayList<CellModel>()
    private val disposeBag = CompositeDisposable()

    fun getBeersData() {
        items.apply {
            add(CellModel("Witbier", R.drawable.witbitter))
            add(CellModel("Berliner Weisse", R.drawable.berliner_weisse))
            add(CellModel("Blond Ale", R.drawable.blond_ale))
            add(CellModel("Paie Ale", R.drawable.ic_launcher_foreground))
            add(CellModel("Golden Ale", R.drawable.ic_launcher_foreground))
            add(CellModel("Tripel", R.drawable.ic_launcher_foreground))
            add(CellModel("India Pale", R.drawable.ic_launcher_foreground))
            add(CellModel("Saison Ale", R.drawable.ic_launcher_foreground))
        }
        viewState.setBeersItems(items)
    }
}