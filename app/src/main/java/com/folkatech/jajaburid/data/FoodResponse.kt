package com.folkatech.jajaburid.data

import com.google.gson.annotations.SerializedName

data class FoodResponse(

	@field:SerializedName("FoodResponse")
	val foodResponse: List<FoodResponseItem?>? = null
)