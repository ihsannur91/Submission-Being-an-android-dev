package com.example.submissionandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionandroid.Response.Response
import com.example.submissionandroid.Response.ResultsItem
import com.example.submissionandroid.databinding.ActivityMainBinding
import com.example.submissionandroid.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	lateinit var recyclerAdapter: AndroidAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.tvSearch.onSubmit { getData(binding.tvSearch.text.toString()) }

		getData()

	}

	private fun getData( search : String? = null) {
		binding.rvMain.layoutManager = LinearLayoutManager(this)
		recyclerAdapter = AndroidAdapter(this)
		binding.rvMain.adapter = recyclerAdapter

		val viewModel:MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
		viewModel.makeApiCall()
		viewModel.getLiveDataObserver().observe(this, Observer {
			Log.d("Response", it.toString())
			if (it != null){
				recyclerAdapter.listData = it
				recyclerAdapter.notifyDataSetChanged()
			} else{
				Toast.makeText(this, "Error getting list", Toast.LENGTH_SHORT).show()
			}
		})

	}

	fun EditText.onSubmit(func: () -> Unit){
		setOnEditorActionListener{ _, actionId, _ ->
			if (actionId == EditorInfo.IME_ACTION_DONE){
				func()
			}
			true
		}
	}
}