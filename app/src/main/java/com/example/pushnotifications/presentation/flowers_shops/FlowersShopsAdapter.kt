package com.example.pushnotifications.presentation.flowers_shops

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pushnotifications.R
import com.example.pushnotifications.databinding.ItemFlowersShopBinding
import com.example.pushnotifications.domain.models.FlowerShopModel

class FlowersShopsAdapter(private val data: List<FlowerShopModel>, private val onClick: () -> Unit) :
    RecyclerView.Adapter<FlowersShopsAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemFlowersShopBinding) : RecyclerView.ViewHolder(binding.root) {
        val flowerImageView: ImageView get() = binding.flowerShopImageView
        val titleTextView: TextView get() = binding.titleTextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFlowersShopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.root.setOnClickListener {
            onClick.invoke()
        }

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Glide.with(viewHolder.binding.root)
            .load(data[position].image)
            .placeholder(R.color.pink)
            .into(viewHolder.flowerImageView)
        viewHolder.titleTextView.text = data[position].shopName
    }

    override fun getItemCount() = data.size
}
