package com.oisab.beers.screens.main.suggestions

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oisab.beers.R
import com.oisab.beers.data.SuggestedBeersListRepository
import dagger.android.support.AndroidSupportInjection
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class SuggestedBeersListFragment : MvpAppCompatFragment(), SuggestedBeersListView {

    @InjectPresenter
    lateinit var suggestedBeersListPresenter: SuggestedBeersListPresenter

    private val beersAdapter = SuggestedBeersListAdapter()
    @Inject lateinit var suggestedBeersListRepository: SuggestedBeersListRepository
    @Inject lateinit var resourceProvider: Resources

    @ProvidePresenter
    fun provideSuggestedBeersPresenter(): SuggestedBeersListPresenter {
        return SuggestedBeersListPresenter(suggestedBeersListRepository)
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

    override fun setBeersItems(items: ArrayList<CellSuggestedBeer>) {
        beersAdapter.setData(items)
    }
}