package com.oisab.beers

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class SuggestedBeersListPresenter @Inject constructor(private val suggestedBeersListRepository: SuggestedBeersListRepository): MvpPresenter<SuggestedBeersListView>() {
    private val items = ArrayList<CellModel>()
    private val disposeBag = CompositeDisposable()

    fun getBeersData() {
        items.apply {
            add(CellModel("Witbier", R.drawable.witbitter))
//            add(CellModel(resourceProvider.getString(R.string.witbier), R.drawable.witbitter))
            add(CellModel("Berliner Weisse", R.drawable.berliner_weisse))
            add(CellModel("Blond Ale", R.drawable.blond_ale))
            add(CellModel("Paie Ale", R.drawable.ic_launcher_foreground))
            add(CellModel("Golden Ale", R.drawable.ic_launcher_foreground))
            add(CellModel("Tripel", R.drawable.ic_launcher_foreground))
            add(CellModel("India Pale", R.drawable.ic_launcher_foreground))
            add(CellModel("Saison Ale", R.drawable.ic_launcher_foreground))
        }
        viewState.setBeersItems(items)
        fetchBeersList()
    }

    private fun fetchBeersList() {
        disposeBag.add(suggestedBeersListRepository.fetchBeersList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("TAG", "${it[0]}")
            }, {
                Log.e("TAG", "Error - $it")
            })
        )
    }

    override fun onDestroy() {
        disposeBag.clear()
        super.onDestroy()
    }
}