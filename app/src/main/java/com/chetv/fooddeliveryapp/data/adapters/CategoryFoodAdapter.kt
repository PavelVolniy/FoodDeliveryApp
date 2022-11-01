package com.chetv.fooddeliveryapp.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chetv.fooddeliveryapp.R

class CategoryFoodAdapter :
    RecyclerView.Adapter<CategoryFoodAdapter.CategoryFoodAdapterViewHolder>() {
    //    var listOfCategory = listOf<FoodItem>()
    private val listOfGroupProduct = listOf("Пицца", "Салаты", "Десерты", "Напитки", "Паста")


    class CategoryFoodAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tv_food_category: TextView = view.findViewById(R.id.tv_food_category)
        fun bind(data: String) {
            tv_food_category.text = data
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryFoodAdapterViewHolder {
        val layout = when(viewType){
            VIEW_TYPE_DISABLED-> R.layout.food_category_item_desabled
            VIEW_TYPE_ENABLED-> R.layout.food_category_item_enabled
            else -> throw RuntimeException("Unknown view type- $viewType")
        }
        val inflater =
            LayoutInflater.from(parent.context)
                .inflate(layout, parent, false)
        return CategoryFoodAdapterViewHolder(inflater)

    }

    override fun onBindViewHolder(holder: CategoryFoodAdapterViewHolder, position: Int) {
        holder.bind(listOfGroupProduct[position])
    }

    override fun getItemCount(): Int {
        return listOfGroupProduct.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_TYPE_ENABLED
        else VIEW_TYPE_DISABLED
    }

    companion object{
        const val VIEW_TYPE_ENABLED = 1
        const val VIEW_TYPE_DISABLED = 0
        const val VIEW_HOLDER_POOL_SIZE = 8
    }
}