package com.example.submissionandroid

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submissionandroid.response.Response
import com.example.submissionandroid.response.ResultsItem
import com.example.submissionandroid.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback

class MainViewModel: ViewModel() {

	var liveDataList: MutableLiveData<List<ResultsItem?>?> = MutableLiveData()

	init {
		makeApiCall()
	}

	fun getLiveDataObserver(): MutableLiveData<List<ResultsItem?>?> {
		Log.d("Response", liveDataList.value.toString() )
		return liveDataList
	}

	fun makeApiCall(searchView : String? = null){
		ApiConfig.service().getGame(searchView).enqueue(object : Callback<Response> {

			override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
				if (response.isSuccessful){
					liveDataList.postValue(response.body()?.results)
				}
			}
			override fun onFailure(call: Call<Response>, t: Throwable) {
				liveDataList.postValue(null)
			}
		})
	}
}

