package com.oisab.beers.screens.main.suggestions

import android.util.Log
import com.oisab.beers.R
import com.oisab.beers.data.SuggestedBeersListRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class SuggestedBeersListPresenter @Inject constructor(private val suggestedBeersListRepository: SuggestedBeersListRepository): MvpPresenter<SuggestedBeersListView>() {
    private val items = ArrayList<CellSuggestedBeer>()
    private val disposeBag = CompositeDisposable()

    fun getBeersData() {
        items.apply {
            add(CellSuggestedBeer("Witbier", R.drawable.witbitter))
//            add(CellModel(resourceProvider.getString(R.string.witbier), R.drawable.witbitter))
            add(CellSuggestedBeer("Berliner Weisse", R.drawable.berliner_weisse))
            add(CellSuggestedBeer("Blond Ale", R.drawable.blond_ale))
            add(CellSuggestedBeer("Paie Ale", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBeer("Golden Ale", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBeer("Tripel", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBeer("India Pale", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBeer("Saison Ale", R.drawable.ic_launcher_foreground))
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