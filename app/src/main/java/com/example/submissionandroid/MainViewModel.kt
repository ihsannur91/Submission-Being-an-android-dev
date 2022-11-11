package com.example.submissionandroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submissionandroid.Response.Response
import com.example.submissionandroid.Response.ResultsItem
import com.example.submissionandroid.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback

class MainViewModel: ViewModel() {

	val liveDataList : MutableLiveData<Response> by lazy {
		MutableLiveData<Response>()
	}

	fun getLiveDataObserver(): MutableLiveData<Response>{
		return liveDataList
	}

	fun makeApiCall(){

	}

}