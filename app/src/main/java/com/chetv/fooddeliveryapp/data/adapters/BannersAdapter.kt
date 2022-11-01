package com.chetv.fooddeliveryapp.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.chetv.fooddeliveryapp.R

class BannersAdapter : RecyclerView.Adapter<BannersAdapter.BannersAdapterViewHolder>() {
    private val list = listOf(1, 2, 3, 4, 5)

    class BannersAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iv_foodBanner = view.findViewById<ImageView>(R.id.iv_food_banner)
        fun bind(data: Int) {
            iv_foodBanner.setImageResource(R.drawable.banner)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannersAdapterViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.food_banner_item, parent, false)
        return BannersAdapterViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: BannersAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}