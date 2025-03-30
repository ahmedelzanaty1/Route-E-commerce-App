package com.example.routee_commerceapp.data.dto.Categories

import com.example.routee_commerceapp.domain.model.home.Categories.CategoriesResponseModel
import com.example.routee_commerceapp.domain.model.home.Categories.CategoryModel
import com.google.gson.annotations.SerializedName

data class CategoriesResponse(

	@field:SerializedName("metadata")
	val metadata: Metadata? = null,

	@field:SerializedName("data")
	val data: List<CategoryDto>? = null,

	@field:SerializedName("results")
	val results: Int? = null
)

data class CategoryDto(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)

data class Metadata(

	@field:SerializedName("numberOfPages")
	val numberOfPages: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("currentPage")
	val currentPage: Int? = null
)
fun CategoryDto.toCategory(): CategoryModel {
	return CategoryModel(
		image = image,
		createdAt = createdAt,
		name = name,
		id = id,
		slug = slug,
		updatedAt = updatedAt
	)

}
