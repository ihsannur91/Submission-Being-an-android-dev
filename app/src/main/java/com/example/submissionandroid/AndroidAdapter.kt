package com.example.submissionandroid

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionandroid.response.ResultsItem
import com.example.submissionandroid.databinding.ItemRowListBinding

class AndroidAdapter(private val activity: Activity): RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder>() {

	var listData: List<ResultsItem>? = null

	inner class AndroidViewHolder(private val binding: ItemRowListBinding): RecyclerView.ViewHolder(binding.root) {

		fun bind(data: ResultsItem){
			binding.apply {
				tvJudul.text = data.name
				tvRate.text = "Rate ${data.rating.toString()}"
				tvDate.text = data.released?.substring(0,10)

				Glide.with(itemView.context)
					.load(data.backgroundImage)
					.error(R.drawable.ic_launcher_background)
					.into(imgAdapter)

				itemView.setOnClickListener {
					val intent = Intent(itemView.context, DetailActivity::class.java)
					intent.putExtra("id", data.id.toString())
					itemView.context.startActivity(intent)
				}
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndroidViewHolder {
		val binding = ItemRowListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return AndroidViewHolder(binding)
	}

	override fun onBindViewHolder(holder: AndroidViewHolder, position: Int) {
		val item = listData?.get(position)
		if (item != null) {
			holder.bind(item)
		}
		}

	override fun getItemCount(): Int {
		if (listData == null) return 0
		else return listData?.size!!
	}
}

