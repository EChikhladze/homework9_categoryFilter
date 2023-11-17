package com.example.homework9_categoryfilter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework9_categoryfilter.databinding.ProductsRecyclerItemBinding

class ProductRecyclerAdapter :
    ListAdapter<Product, ProductRecyclerAdapter.ProductViewHolder>(object :
        DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }) {

    fun setData(products: List<Product>) {
        submitList(products)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ProductsRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind()
    }

    inner class ProductViewHolder(private val binding: ProductsRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val product = currentList[adapterPosition]
            binding.tvProductName.text = product.name
            binding.tvProductPrice.text = "$" + product.price.toString()
            binding.imgProduct.setImageResource(product.photo)
        }
    }
}