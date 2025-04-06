package com.example.routee_commerceapp.data.dto.Product

import com.example.routee_commerceapp.domain.model.home.Product.DataModel
import com.example.routee_commerceapp.domain.model.home.Product.DetailsResponseModel
import com.google.gson.annotations.SerializedName

data class DetailsResponse(

	@field:SerializedName("data")
	val data: Data? = null
) {
	fun toProduct(): DetailsResponseModel {
		return DetailsResponseModel(
			data = data?.toData()
		)

	}
}

data class BrandDetails(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)

data class SubcategoryItemDetails(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)

data class CategoryDetails(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)

data class Data(

	@field:SerializedName("sold")
	val sold: Int? = null,

	@field:SerializedName("images")
	val images: List<String?>? = null,

	@field:SerializedName("quantity")
	val quantity: Int? = null,

	@field:SerializedName("imageCover")
	val imageCover: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("ratingsQuantity")
	val ratingsQuantity: Int? = null,

	@field:SerializedName("ratingsAverage")
	val ratingsAverage: Any? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("reviews")
	val reviews: List<Any?>? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("__v")
	val v: Int? = null,

	@field:SerializedName("_id")
	val id: String? = null,


	@field:SerializedName("subcategory")
	val subcategory: List<SubcategoryItemDetails?>? = null,

	@field:SerializedName("category")
	val category: CategoryDetails? = null,

	@field:SerializedName("brand")
	val brand: BrandDetails? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)

fun Data.toData(): DataModel {
	return DataModel(
		sold = sold,
		images = images,
		quantity = quantity,
		imageCover = imageCover,
		description = description,
		title = title,
		ratingsQuantity = ratingsQuantity,
		ratingsAverage = ratingsAverage,
		createdAt = createdAt,
		reviews = reviews,
		price = price,
		v = v,
		id = id,
		subcategory = subcategory,
		category = category,
		brand = brand,
		slug = slug,
		updatedAt = updatedAt


	)
	fun DetailsResponse.toProduct(): DetailsResponseModel {
		return DetailsResponseModel(
			data = data?.toData()
		)
	}
}
