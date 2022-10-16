package com.chetv.fooddeliveryapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chetv.fooddeliveryapp.R

class CategoryFoodAdapter: RecyclerView.Adapter<CategoryFoodAdapter.CategoryFoodAdapterViewHolder>() {
//    var listOfCategory = listOf<FoodItem>()
    val list = listOf(0,1,2,3,4)


    class CategoryFoodAdapterViewHolder(view: View): RecyclerView.ViewHolder(view){
        val listOfGroupProduct = listOf("Пицца", "Роллы", "Закуски", "Снеки", "Напитки")
        private val tv_food_category: TextView = view.findViewById(R.id.tv_food_category)
        fun bind(data: Int){
            tv_food_category.text = listOfGroupProduct[data]
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryFoodAdapterViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.food_category_item_enabled, parent, false)
        return CategoryFoodAdapterViewHolder(inflater)

    }

    override fun onBindViewHolder(holder: CategoryFoodAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}