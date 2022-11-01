package com.chetv.fooddeliveryapp.data.adapters

import android.app.Application
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.chetv.fooddeliveryapp.R
import com.chetv.fooddeliveryapp.data.json.JsonItemGunterFoodApi

class FoodItemsAdapter : RecyclerView.Adapter<FoodItemsAdapter.FoodItemsAdapterViewHolder>() {
    var list = mutableListOf<JsonItemGunterFoodApi>()
    var application: Application? = null

    class FoodItemsAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tv_foodName = view.findViewById<TextView>(R.id.tv_food_name)
        val tv_foodDescription = view.findViewById<TextView>(R.id.tv_food_description)
        val iv_foodImage = view.findViewById<ImageView>(R.id.iv_food_image)
        val tv_foodComponents = view.findViewById<TextView>(R.id.tv_food_components)
        val tv_foodPrice = view.findViewById<TextView>(R.id.tv_food_price)

        fun bind(data: JsonItemGunterFoodApi, application: Application?) {
            tv_foodName.text = data.name
            tv_foodDescription.text = data.description
            tv_foodComponents.text = StringBuilder().apply {
                for (i in data.ingredients) {
                    this.append(" ")
                    this.append("$i,")
                }
            }.trim(',').trim(' ')

            tv_foodPrice.text = "${data.price} $"

// load image from url
            Glide.with(application!!)
                .asBitmap()
                .load(data.image)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        iv_foodImage.setImageBitmap(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                    }

                })
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemsAdapterViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return FoodItemsAdapterViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: FoodItemsAdapterViewHolder, position: Int) {
        holder.bind(list[position], application)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}


