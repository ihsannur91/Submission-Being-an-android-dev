package com.example.submissionandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.submissionandroid.Response.ResponseDetail
import com.example.submissionandroid.databinding.ActivityDetailBinding
import com.example.submissionandroid.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

	private lateinit var binding: ActivityDetailBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityDetailBinding.inflate(layoutInflater)
		setContentView(binding.root)

			var loading = ProgressDialog.progressDialog(this)
			loading.show()

			val id = intent.getStringExtra("id")
			ApiConfig.service().getGameDetail(id.toString()).enqueue(object : Callback<ResponseDetail>{
				override fun onResponse(
					call: Call<ResponseDetail>,
					response: Response<ResponseDetail>
				) {
					Log.d("ResponseDetail", response.toString())
					if (response.isSuccessful){
						val responseBody = response.body()
						Log.d("ResponseNody", responseBody.toString())

						binding.apply {
							tvJudul.text = responseBody?.name
							tvDeskripsi.text = responseBody?.description

							Glide.with(this@DetailActivity)
								.load(responseBody?.backgroundImage)
								.error(R.drawable.ic_launcher_background)
								.into(imgGames)
						}
					}

					loading.dismiss()

				}

				override fun onFailure(call: Call<ResponseDetail>, t: Throwable) {
					loading.dismiss()
					Toast.makeText(this@DetailActivity,t.localizedMessage, Toast.LENGTH_SHORT).show()
				}
			})
		}

	}
