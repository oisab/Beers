package com.oisab.beers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BeersListFragment: Fragment(R.layout.beers_list_fragment) {
    private val beersAdapter = BeersAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val beersRecyclerView: RecyclerView = view.findViewById(R.id.beersRecyclerView)
        beersRecyclerView.adapter = beersAdapter
        beersRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        generateData()
    }

    private fun generateData() {
        beersAdapter.setData(
                ArrayList<CellModel>().apply {
                    add(CellModel("Witbier", R.drawable.witbitter))
                    add(CellModel("Berliner Weisse", R.drawable.berliner_weisse))
                    add(CellModel("Blond Ale", R.drawable.blond_ale))
                    add(CellModel("Paie Ale", R.drawable.ic_launcher_foreground))
                    add(CellModel("Golden Ale", R.drawable.ic_launcher_foreground))
                    add(CellModel("Tripel", R.drawable.ic_launcher_foreground))
                    add(CellModel("India Pale", R.drawable.ic_launcher_foreground))
                    add(CellModel("Saison Ale", R.drawable.ic_launcher_foreground))
                })
    }
}