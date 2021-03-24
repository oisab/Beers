package com.oisab.beers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class BeersListView: MvpAppCompatFragment(), IBeersListView {

    @InjectPresenter lateinit var beersListPresenter: BeersListPresenter
    private val beersAdapter = BeersAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createBeersList()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.beers_list_fragment, container, false)
    }

    override fun createBeersList() {
        val beersRecyclerView: RecyclerView? = view?.findViewById(R.id.beersRecyclerView)
        beersRecyclerView?.adapter = beersAdapter
        beersRecyclerView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        beersListPresenter.generateData(beersAdapter)
    }
}