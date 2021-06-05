package com.oisab.beers

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.AndroidSupportInjection
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class SuggestedBeersListFragment : MvpAppCompatFragment(), SuggestedBeersListView {

    @InjectPresenter
    lateinit var suggestedBeersListPresenter: SuggestedBeersListPresenter

    private val beersAdapter = SuggestedBeersListAdapter()
    @Inject lateinit var beersApi: BeersApi
    @Inject lateinit var resourceProvider: Resources

    @ProvidePresenter
    fun provideSuggestedBeersPresenter(): SuggestedBeersListPresenter {
        return SuggestedBeersListPresenter(beersApi)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

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
    }

    override fun setBeersItems(items: ArrayList<CellModel>) {
        beersAdapter.setData(items)
    }
}