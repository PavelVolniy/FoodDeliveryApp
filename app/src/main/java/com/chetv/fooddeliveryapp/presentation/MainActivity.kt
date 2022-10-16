package com.chetv.fooddeliveryapp.presentation

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chetv.fooddeliveryapp.R
import com.chetv.fooddeliveryapp.adapters.BannersAdapter
import com.chetv.fooddeliveryapp.adapters.CategoryFoodAdapter
import com.chetv.fooddeliveryapp.adapters.FoodItemsAdapter

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var foodItemsAdapter: FoodItemsAdapter
    lateinit var bannersAdapter: BannersAdapter
    lateinit var categoryFoodAdapter: CategoryFoodAdapter
    lateinit var qrButton: ImageButton
    lateinit var cityNameSpinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initRecyclerView()
        loadData()

        findViewById<ImageButton>(R.id.ib_qr_code_button).setOnClickListener {
            Toast.makeText(this, "В разработке", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initRecyclerView() {
        val recyclerViewFoodItems = findViewById<RecyclerView>(R.id.rv_food_items)
        recyclerViewFoodItems.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            foodItemsAdapter = FoodItemsAdapter()
            adapter = foodItemsAdapter
        }
        val recyclerViewBannersAdapter = findViewById<RecyclerView>(R.id.rv_banners)
        recyclerViewBannersAdapter.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            bannersAdapter = BannersAdapter()
            adapter = bannersAdapter
        }
        val recyclerViewCategoryFoodAdapter = findViewById<RecyclerView>(R.id.rv_category_buttons)
        recyclerViewCategoryFoodAdapter.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            categoryFoodAdapter = CategoryFoodAdapter()
            adapter = categoryFoodAdapter
        }
        val spinner = findViewById<Spinner>(R.id.sp_name_city_delivery)
        ArrayAdapter.createFromResource(this, R.array.city_names, android.R.layout.simple_spinner_item)
            .also { adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter}
    }

    private fun initViews() {
        qrButton = findViewById(R.id.ib_qr_code_button)
        cityNameSpinner = findViewById(R.id.sp_name_city_delivery)
    }

    private fun loadData() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getJsonResultObserver().observe(this) {
            if (it != null) {
//                foodItemsAdapter.list = it.results.
//                foodItemsAdapter.notifyDataSetChanged()
            }
        }
//        viewModel.makeRequest()
    }

}