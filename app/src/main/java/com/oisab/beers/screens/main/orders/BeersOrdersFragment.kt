package com.oisab.beers.screens.main.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.oisab.beers.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class BeersOrdersFragment : MvpAppCompatFragment(), BeersOrdersView {
    @InjectPresenter
    lateinit var beersOrdersPresenter: BeersOrdersPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.beers_order_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buyButton: AppCompatButton = view.findViewById(R.id.buyButton)
        val textOrdersCount = view.findViewById<TextView>(R.id.textOrdersCount)

        buyButton.setOnClickListener {
            beersOrdersPresenter.dataSource()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        textOrdersCount.text = it.toString()
                    }
        }
    }
}