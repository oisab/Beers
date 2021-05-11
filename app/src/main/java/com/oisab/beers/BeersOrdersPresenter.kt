package com.oisab.beers

import io.reactivex.rxjava3.core.Observable
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class BeersOrdersPresenter : MvpPresenter<BeersOrdersView>() {
    private var i = 0

    fun dataSource(): Observable<Int> {
        return Observable.create{ subscriber ->
            subscriber.onNext(++i)
        }
    }
}