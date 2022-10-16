package com.chetv.fooddeliveryapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chetv.fooddeliveryapp.R

class FoodItemsAdapter : RecyclerView.Adapter<FoodItemsAdapter.FoodItemsAdapterViewHolder>() {
//    var list = listOf<com.chetv.fooddeliveryapp.data.json.Result>()
    var list = listOf(1,2,3,4,5,6,7,8,9,10)

    class FoodItemsAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tv_foodName = view.findViewById<TextView>(R.id.tv_food_name)
        val tv_foodDescription = view.findViewById<TextView>(R.id.tv_food_description)
        val iv_foodImage = view.findViewById<ImageView>(R.id.iv_food_image)

        fun bind(data: Int) {
//            tv_foodName.text = data.id.toString()
//            tv_foodDescription.text = data.title
            tv_foodName.text = "Ветчина и грибы"
            tv_foodDescription.text = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус"
            Log.e("++++++++++++++++++++", "${tv_foodName.text} - ${tv_foodDescription.text}")
            iv_foodImage.setImageResource(R.drawable.pizza1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemsAdapterViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return FoodItemsAdapterViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: FoodItemsAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}


