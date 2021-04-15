package com.oisab.beers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import moxy.MvpAppCompatFragment

class BeersOrdersFragment : MvpAppCompatFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.beers_order_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buyButton: AppCompatButton = view.findViewById(R.id.buyButton)

        buyButton.setOnClickListener {
            Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
        }
    }
}