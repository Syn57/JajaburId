package com.folkatech.jajaburid.data.network

import com.google.gson.annotations.SerializedName

data class FoodResponseItem(

	@field:SerializedName("cover")
	val cover: String? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("desc")
	val desc: String? = null
)