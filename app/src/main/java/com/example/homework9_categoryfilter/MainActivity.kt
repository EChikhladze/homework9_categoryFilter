package com.example.homework9_categoryfilter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework9_categoryfilter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var categories: List<Category>
    private lateinit var products: List<Product>
    private lateinit var categoriesAdapter: CategoryRecyclerAdapter
    private lateinit var productsAdapter: ProductRecyclerAdapter
    private val productsColumnsNumber = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUp()
    }

    private fun setUp() {
        loadCategories()
        loadProducts()
        setUpRecycler()
        setOnClickListeners()
    }


    private fun loadCategories() {
        categories = listOf(
            Category("All"),
            Category("\uD83C\uDF89 Party"),
            Category("\uD83C\uDFD5 Camping"),
            Category("Category1"),
            Category("Category2"),
            Category("Category3")
        )
    }

    private fun loadProducts() {
        products = listOf(
            Product(
                1,
                "Belt suit blazer",
                120,
                R.drawable.product_1,
                listOf(Category("All"), Category("\uD83C\uDF89 Party"))
            ),
            Product(
                2,
                "Belt suit blazer",
                120,
                R.drawable.product_2,
                listOf(Category("All"), Category("\uD83C\uDFD5 Camping"))
            ),
            Product(
                3,
                "Belt suit blazer",
                120,
                R.drawable.product_3,
                listOf(Category("All"), Category("Category1"), Category("Category2"))
            ),
            Product(
                4,
                "Belt suit blazer",
                120,
                R.drawable.product_4,
                listOf(Category("All"), Category("\uD83C\uDFD5 Camping"))
            ),
            Product(
                5,
                "Belt suit blazer",
                120,
                R.drawable.product_4,
                listOf(Category("All"), Category("Category3"))
            )
        )
    }

    private fun setUpRecycler() {
        binding.recyclerViewCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoriesAdapter = CategoryRecyclerAdapter(categories)
        binding.recyclerViewCategories.adapter = categoriesAdapter
        binding.recyclerViewCategories.setHasFixedSize(true)

        binding.recyclerViewProducts.layoutManager = GridLayoutManager(this, productsColumnsNumber)
        productsAdapter = ProductRecyclerAdapter()
        binding.recyclerViewProducts.adapter = productsAdapter
        productsAdapter.setData(products)
    }


    private fun setOnClickListeners() {
        categoriesAdapter.setOnClickListener(object : CategoryRecyclerAdapter.OnClickListener {
            override fun onClick(position: Int, category: Category) {
                val currCategoryProducts: MutableList<Product> = mutableListOf()
                for (product in products) {
                    if (product.categories.contains(category)) {
                        currCategoryProducts.add(product)
                    }
                }

                Log.d("categoryProducts", currCategoryProducts.toString())
                productsAdapter.setData(currCategoryProducts)
            }
        })
    }

}