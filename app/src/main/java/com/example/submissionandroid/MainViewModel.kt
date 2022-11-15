package com.example.submissionandroid

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionandroid.Response.Response
import com.example.submissionandroid.Response.ResultsItem
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

	fun makeApiCall(){
		ApiConfig.service().getGame(search = null).enqueue(object : Callback<Response> {
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

