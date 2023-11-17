package com.example.homework9_categoryfilter

data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val photo: Int,
    val categories: List<Category>
)
