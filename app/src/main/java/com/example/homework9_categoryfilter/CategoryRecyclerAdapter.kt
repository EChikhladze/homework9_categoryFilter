package com.example.homework9_categoryfilter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework9_categoryfilter.databinding.CategoriesRecyclerItemBinding

class CategoryRecyclerAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>() {

    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            CategoriesRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
//        holder.itemView.setOnClickListener {
//            Log.d("categoryProducts", "Category clicked")
//            if (onClickListener != null) {
//                onClickListener!!.onClick(position, category)
//            }
//        }
    }

    inner class CategoryViewHolder(private val binding: CategoriesRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.btnCategory.text = category.category
            binding.btnCategory.setOnClickListener {
                Log.d("categoryProducts", "Category clicked")
                if (onClickListener != null) {
                    onClickListener!!.onClick(adapterPosition, category)
                }
            }
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, category: Category)
    }
}