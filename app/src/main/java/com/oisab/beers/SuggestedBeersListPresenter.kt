package com.oisab.beers

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.internal.util.ErrorMode
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import okhttp3.internal.http2.ErrorCode

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

    fun fetchBeersList(beersApi: BeersApi) {
        disposeBag.add(beersApi.getBeersList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       Log.e("TAG", "${it[10]}")
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