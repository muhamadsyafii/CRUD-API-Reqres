package com.syafii.crudapireqres.model

import com.google.gson.annotations.SerializedName

data class User(

	val name: String? = null,
	val job: String? = null,
	val email: String? = null,
	var password: String? = null
)
