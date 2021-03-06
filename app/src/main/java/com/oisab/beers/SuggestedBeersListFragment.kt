package com.oisab.beers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class SuggestedBeersListFragment : MvpAppCompatFragment(), SuggestedBeersListView {

    @InjectPresenter
    lateinit var suggestedBeersListPresenter: SuggestedBeersListPresenter
    private val beersAdapter = SuggestedBeersListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.suggested_beers_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val beersRecyclerView: RecyclerView? = view.findViewById(R.id.beersRecyclerView)
        beersRecyclerView?.adapter = beersAdapter
        beersRecyclerView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        suggestedBeersListPresenter.getBeersData()
        suggestedBeersListPresenter.fetchBeersList((activity?.application as BeersApp).beersApi)
    }

    override fun setBeersItems(items: ArrayList<CellModel>) {
        beersAdapter.setData(items)
    }
}