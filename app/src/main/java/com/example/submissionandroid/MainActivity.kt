package com.example.submissionandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionandroid.databinding.ActivityMainBinding
import com.example.submissionandroid.response.ResultsItem

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	lateinit var recyclerAdapter: AndroidAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)


		binding.tvSearch.setOnQueryTextListener(object : OnQueryTextListener {
			override fun onQueryTextSubmit(p0: String?): Boolean {
				if (p0 != null) {
					getData(p0)
				}
				return true
			}
			override fun onQueryTextChange(p0: String?): Boolean {

				getData(p0)

				return false
			}
		})

		getData()
	}

	private fun getData( search : String? = null) {

		val loading = ProgressDialog.progressDialog(this)
		loading.show()

		if (search != null) {
			Log.d("search", search)
		}



		binding.rvMain.layoutManager = LinearLayoutManager(this)
		recyclerAdapter = AndroidAdapter(this)
		binding.rvMain.adapter = recyclerAdapter

		val viewModel:MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
		viewModel.makeApiCall(search)
		viewModel.getLiveDataObserver().observe(this, Observer {
			Log.d("Response", it.toString())
			if (it != null){
				recyclerAdapter.listData = it as List<ResultsItem>?
				recyclerAdapter.notifyDataSetChanged()
				loading.dismiss()
			} else{
				Toast.makeText(this, "Error getting list", Toast.LENGTH_SHORT).show()
			}
		})

	}

}

