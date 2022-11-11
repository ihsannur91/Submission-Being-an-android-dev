package com.example.submissionandroid.network

import com.example.submissionandroid.Response.Response
import com.example.submissionandroid.Response.ResponseDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

	@GET("games?key=$API_KEY")
	fun getGame(@Query ("search") search : String? = null ): Call<Response>

	companion object{
		const val API_KEY = "2dad9bf4469d42068d5f065f594bea76"
	}

	@GET("games/{id}?key=$API_KEY")
	fun getGameDetail(@Path("id") id : String): Call<ResponseDetail>
}