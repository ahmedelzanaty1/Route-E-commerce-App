package com.example.routee_commerceapp.domain.model.home.Product

import com.example.routee_commerceapp.data.dto.Product.BrandDetails
import com.example.routee_commerceapp.data.dto.Product.CategoryDetails
import com.example.routee_commerceapp.data.dto.Product.SubcategoryItemDetails

data class DetailsResponseModel(
	val data: DataModel? = null
)

data class SubcategoryItemModel(
	val name: String? = null,
	val id: String? = null,
	val category: String? = null,
	val slug: String? = null
)

data class BrandModel(
	val image: String? = null,
	val name: String? = null,
	val id: String? = null,
	val slug: String? = null
)

data class CategoryModel(
	val image: String? = null,
	val name: String? = null,
	val id: String? = null,
	val slug: String? = null
)

data class DataModel(
	val sold: Int? = null,
	val images: List<String?>? = null,
	val quantity: Int? = null,
	val imageCover: String? = null,
	val description: String? = null,
	val title: String? = null,
	val ratingsQuantity: Int? = null,
	val ratingsAverage: Any? = null,
	val createdAt: String? = null,
	val reviews: List<Any?>? = null,
	val price: Int? = null,
	val v: Int? = null,
	val id: String? = null,
	val subcategory: List<SubcategoryItemDetails?>? = null,
	val category: CategoryDetails? = null,
	val brand: BrandDetails? = null,
	val slug: String? = null,
	val updatedAt: String? = null
)

