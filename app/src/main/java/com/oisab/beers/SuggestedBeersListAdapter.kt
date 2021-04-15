package com.oisab.beers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class SuggestedBeersListAdapter : RecyclerView.Adapter<SuggestedBeersListAdapter.BeersViewHolder>() {
    private val items: MutableList<CellModel> = ArrayList()

    fun setData(data: List<CellModel>) {
        this.items.clear()
        this.items.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeersViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return BeersViewHolder(layoutInflater.inflate(R.layout.cell_test, parent, false))
    }

    override fun onBindViewHolder(holder: BeersViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class BeersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: AppCompatTextView = itemView.findViewById(R.id.beerTitleView)
        private val iconView: AppCompatImageView = itemView.findViewById(R.id.beerIconView)

        fun bind(model: CellModel) {
            if (model.icon > 0) {
                iconView.setImageResource(model.icon)
            }
            textView.text = model.name
        }
    }
}