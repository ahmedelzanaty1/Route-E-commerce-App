package com.example.routee_commerceapp.domain.model.home.Product

import com.example.routee_commerceapp.data.dto.Product.Brand
import com.example.routee_commerceapp.data.dto.Product.Category
import com.example.routee_commerceapp.data.dto.Product.SubcategoryItem

data class ProductsResponseModel(
	val metadata: Metadata? = null,
	val data: List<ProductModel?>? = null,
	val results: Int? = null
)

data class SubcategoryItem(
	val name: String? = null,
	val id: String? = null,
	val category: String? = null,
	val slug: String? = null
)

data class Brand(
	val image: String? = null,
	val name: String? = null,
	val id: String? = null,
	val slug: String? = null
)

data class Category(
	val image: String? = null,
	val name: String? = null,
	val id: String? = null,
	val slug: String? = null
)

data class Metadata(
	val numberOfPages: Int? = null,
	val nextPage: Int? = null,
	val limit: Int? = null,
	val currentPage: Int? = null
)

data class ProductModel(
	val sold: Int? = null,
	val images: List<String?>? = null,
	val quantity: Int? = null,
	val availableColors: List<Any?>? = null,
	val imageCover: String? = null,
	val description: String? = null,
	val title: String? = null,
	val ratingsQuantity: Int? = null,
	val ratingsAverage: Any? = null,
	val createdAt: String? = null,
	val price: Int? = null,
	val id: String? = null,
	val subcategory: List<SubcategoryItem?>? = null,
	val category: Category? = null,
	val brand: Brand? = null,
	val slug: String? = null,
	val updatedAt: String? = null,
	val priceAfterDiscount: Int? = null
)

