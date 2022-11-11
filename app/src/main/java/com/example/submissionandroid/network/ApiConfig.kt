package com.example.submissionandroid.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

	const val baseUrl = "https://api.rawg.io/api/"

	private fun retrofit(): Retrofit{
		return Retrofit.Builder()
			.baseUrl(baseUrl)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
	}

	fun service(): ApiService{
		return retrofit().create(ApiService::class.java)
	}
}