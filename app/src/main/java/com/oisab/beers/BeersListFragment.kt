package com.oisab.beers

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class BeersListFragment: MvpAppCompatFragment(), IBeersListFragment {
    @InjectPresenter lateinit var beersListPresenter: BeersListPresenter
    private val beersAdapter = BeersAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createBeersList()
    }

    override fun createBeersList() {
        val beersRecyclerView: RecyclerView? = view?.findViewById(R.id.beersRecyclerView)
        beersRecyclerView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        beersListPresenter.generateData(beersAdapter)
    }
}