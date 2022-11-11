package com.example.submissionandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
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

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.tvSearch.onSubmit { getData(binding.tvSearch.text.toString()) }

		getData()

	}

	private fun getData( search : String? = null) {

		var loading = ProgressDialog.progressDialog(this)
		loading.show()

		ApiConfig.service().getGame(search).enqueue(object : Callback<Response> {
			override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
				if (response.isSuccessful){
					val responseBody = response.body()
					val listDataGame = responseBody?.results?.sortedBy { it?.released }
					//memanggil adapter
					val androidAdapter = AndroidAdapter(listDataGame as List<ResultsItem>)
					//buat nampilin list dari adapter ke view

					binding.rvMain.apply {
						layoutManager = LinearLayoutManager(this@MainActivity)
						setHasFixedSize(true)
						adapter = androidAdapter

					}
				}
					loading.dismiss()
			}

			override fun onFailure(call: Call<Response>, t: Throwable) {
				loading.dismiss()
				Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
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