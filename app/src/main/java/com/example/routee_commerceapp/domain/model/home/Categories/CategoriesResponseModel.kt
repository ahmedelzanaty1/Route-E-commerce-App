package com.example.routee_commerceapp.domain.model.home.Categories

data class CategoriesResponseModel(
	val metadata: Metadata? = null,
	val data: List<CategoryModel?>? = null,
	val results: Int? = null
)

data class CategoryModel(
	val image: String? = null,
	val createdAt: String? = null,
	val name: String? = null,
	val id: String? = null,
	val slug: String? = null,
	val updatedAt: String? = null
)

data class Metadata(
	val numberOfPages: Int? = null,
	val limit: Int? = null,
	val currentPage: Int? = null
)

