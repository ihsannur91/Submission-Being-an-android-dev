package com.example.submissionandroid

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionandroid.Response.ResultsItem
import com.example.submissionandroid.databinding.ItemRowListBinding
import kotlin.math.log

class AndroidAdapter(private val listData: List<ResultsItem>): RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder>() {

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
		val item = listData[position]
		holder.bind(item)
		}

	override fun getItemCount(): Int {
		return listData.size
	}
}

